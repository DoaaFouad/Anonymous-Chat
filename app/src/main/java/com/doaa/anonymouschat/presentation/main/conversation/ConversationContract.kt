/*
 * *
 * Created by Doaa Fouad on 1/14/22 4:39 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 4:39 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.conversation

import com.doaa.anonymouschat.presentation.base.ViewEffect
import com.doaa.anonymouschat.presentation.base.ViewIntent
import com.doaa.anonymouschat.presentation.base.ViewState

class ConversationContract {

    sealed class Intent : ViewIntent {
        data class InitConversation(val publicKey: String) : Intent()
        data class SendMessage(val message: String?) : Intent()
    }

    data class State(
        val conversationViewState: ConversationViewState
    ) : ViewState

    sealed class ConversationViewState {
        object Idle : ConversationViewState()
        object Loading : ConversationViewState()
    }

    sealed class Effect : ViewEffect {
        data class ShowServerErrorToast(val message: String) : Effect()
    }
}