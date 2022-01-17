/*
 * *
 * Created by Doaa Fouad on 1/13/22 10:54 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/13/22 10:54 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.public_key_generation

import com.doaa.anonymouschat.data.cache.EncryptedSharedPreferenceRepository
import com.doaa.anonymouschat.presentation.base.BaseViewModel
import com.doaa.anonymouschat.utils.KeyPairGenerator
import kotlin.random.Random

class GeneratePublicKeyViewModel(val sharedPreferenceRepository: EncryptedSharedPreferenceRepository) :
    BaseViewModel<GeneratePublicKeyContract.Intent, GeneratePublicKeyContract.State, GeneratePublicKeyContract.Effect>() {

    override fun createInitialState(): GeneratePublicKeyContract.State {
        return GeneratePublicKeyContract.State(GeneratePublicKeyContract.GeneratePublicKeyViewState.Idle)
    }

    override suspend fun handleIntent(intent: GeneratePublicKeyContract.Intent) {
        when(intent) {
            is GeneratePublicKeyContract.Intent.GeneratePublicKey -> {
                generatePublicKey()
            }
        }
    }

    private fun generatePublicKey(){
      val keyPairResult = KeyPairGenerator.generate()
        setState {
            copy(
                generatePublicKeyViewState = GeneratePublicKeyContract.GeneratePublicKeyViewState.GeneratePublicKeySuccess(
                   keyPairResult = keyPairResult
                )
            )
        }

        sharedPreferenceRepository.setPublicKey(keyPairResult?.ed25519KeyPair?.publicKey?.asHexString ?: "")
        sharedPreferenceRepository.setPrivateKey(keyPairResult?.ed25519KeyPair?.secretKey?.asHexString ?: "")
        sharedPreferenceRepository.setUserName("Anonymous${Random.nextInt(500)}" ?: "")
    }
}