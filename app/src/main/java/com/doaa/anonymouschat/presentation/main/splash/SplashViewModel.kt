/*
 * *
 * Created by Doaa Fouad on 1/17/22 7:09 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 7:09 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.splash

import com.doaa.anonymouschat.data.cache.EncryptedSharedPreferenceRepository
import com.doaa.anonymouschat.presentation.base.BaseViewModel

class SplashViewModel(val sharedPreferenceRepository: EncryptedSharedPreferenceRepository) :
    BaseViewModel<SplashContract.Intent, SplashContract.State, SplashContract.Effect>() {

    override fun createInitialState(): SplashContract.State {
        return SplashContract.State(SplashContract.SplashViewState.Idle)
    }

    override suspend fun handleIntent(intent: SplashContract.Intent) {
        when (intent) {
            is SplashContract.Intent.CheckNavigationFlow -> {
                checkNavigationFlow()
            }
        }
    }

    private fun checkNavigationFlow() {
        val publicKey = sharedPreferenceRepository.getPublicKey()
        if (publicKey.isEmpty()) {
            setState {
                copy(
                    splashViewState = SplashContract.SplashViewState.NavigationFLow(NavigationDestination.PublicKeyGeneration)
                )
            }
        } else {
            setState {
                copy(
                    splashViewState = SplashContract.SplashViewState.NavigationFLow(NavigationDestination.UserHome)
                )
            }
        }
    }
}