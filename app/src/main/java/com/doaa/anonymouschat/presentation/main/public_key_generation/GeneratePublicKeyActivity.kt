/*
 * *
 * Created by Doaa Fouad on 1/13/22 10:26 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/13/22 10:26 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.public_key_generation

import androidx.lifecycle.lifecycleScope
import com.doaa.anonymouschat.databinding.ActivityGeneratePublicKeyBinding
import com.doaa.anonymouschat.domain.entities.crypto.KeyPairResult
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.utils.crypto.hexEncodedPublicKey
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.coroutines.flow.collect

class GeneratePublicKeyActivity :
    BaseActivity<GeneratePublicKeyContract.Intent, GeneratePublicKeyContract.State, GeneratePublicKeyContract.Effect, ActivityGeneratePublicKeyBinding>() {

    override val viewModel by viewModel<GeneratePublicKeyViewModel>()

    override fun init() {
        super.init()

        viewModel.setIntent(GeneratePublicKeyContract.Intent.GeneratePublicKey)
    }

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.generatePublicKeyViewState) {
                    is GeneratePublicKeyContract.GeneratePublicKeyViewState.Idle -> {

                    }

                    is GeneratePublicKeyContract.GeneratePublicKeyViewState.Loading -> {

                    }

                    is GeneratePublicKeyContract.GeneratePublicKeyViewState.GeneratePublicKeySuccess -> {
                        updatePublicKeyView(state.keyPairResult)
                    }
                }

            }
        }
    }

    private fun updatePublicKeyView(keyPairResult: KeyPairResult?){
        keyPairResult?.let { _keyPairResult ->
            binding?.tvPublicKey?.text = _keyPairResult.x25519KeyPair.hexEncodedPublicKey
        }
    }

    override fun getViewBinding(): ActivityGeneratePublicKeyBinding {
        return ActivityGeneratePublicKeyBinding.inflate(layoutInflater)
    }
}