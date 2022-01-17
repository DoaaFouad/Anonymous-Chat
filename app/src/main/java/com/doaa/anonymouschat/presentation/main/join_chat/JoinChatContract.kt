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

import com.doaa.anonymouschat.presentation.base.ViewEffect
import com.doaa.anonymouschat.presentation.base.ViewIntent
import com.doaa.anonymouschat.presentation.base.ViewState

class JoinChatContract {

    sealed class Intent : ViewIntent {
        object JoinChat : Intent()
    }

    data class State(
        val joinChatViewState: JoinChatViewState
    ) : ViewState

    sealed class JoinChatViewState {
        object Idle : JoinChatViewState()
        object Loading : JoinChatViewState()
    }

    sealed class Effect : ViewEffect {
        data class ShowServerErrorToast(val message: String) : Effect()
    }
}