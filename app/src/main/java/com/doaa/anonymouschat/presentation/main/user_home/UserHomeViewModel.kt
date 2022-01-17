/*
 * *
 * Created by Doaa Fouad on 1/17/22 8:39 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 8:39 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.user_home

import com.doaa.anonymouschat.data.cache.EncryptedSharedPreferenceRepository
import com.doaa.anonymouschat.presentation.base.BaseViewModel

class UserHomeViewModel(val sharedPreferenceRepository: EncryptedSharedPreferenceRepository) :
    BaseViewModel<UserHomeContract.Intent, UserHomeContract.State, UserHomeContract.Effect>() {

    override fun createInitialState(): UserHomeContract.State {
        return UserHomeContract.State(UserHomeContract.UserHomeViewState.Idle)
    }

    override suspend fun handleIntent(intent: UserHomeContract.Intent) {
        when (intent) {
            is UserHomeContract.Intent.GetUserInfo -> {
                getUserInfo()
            }
        }
    }

    private fun getUserInfo() {
        val userName = sharedPreferenceRepository.getUserName()
        val publicKey = sharedPreferenceRepository.getPublicKey()

        setState {
            copy(
                userHomeViewState = UserHomeContract.UserHomeViewState.UserInfoSuccess(
                    userName = userName,
                    publicKey = publicKey
                )
            )
        }

    }
}