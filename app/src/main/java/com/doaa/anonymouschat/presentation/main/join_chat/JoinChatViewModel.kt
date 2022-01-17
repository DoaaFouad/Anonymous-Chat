/*
 * *
 * Created by Doaa Fouad on 1/14/22 2:54 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 2:54 AM
 *
 */

package com.doaa.anonymouschat.presentation.main.join_chat

import com.doaa.anonymouschat.presentation.base.BaseViewModel

class JoinChatViewModel :
    BaseViewModel<JoinChatContract.Intent, JoinChatContract.State, JoinChatContract.Effect>() {

    override fun createInitialState(): JoinChatContract.State {
        return JoinChatContract.State(JoinChatContract.JoinChatViewState.Idle)
    }

    override suspend fun handleIntent(intent: JoinChatContract.Intent) {
        when (intent) {
            is JoinChatContract.Intent.JoinChat -> {
            }
        }
    }
}