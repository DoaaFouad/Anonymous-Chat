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

import com.doaa.anonymouschat.domain.entities.messaging.ConversationListItemModel
import com.doaa.anonymouschat.presentation.base.ViewEffect
import com.doaa.anonymouschat.presentation.base.ViewIntent
import com.doaa.anonymouschat.presentation.base.ViewState

class UserHomeContract {

    sealed class Intent : ViewIntent {
        object GetUserInfo : Intent()
    }

    data class State(
        val userHomeViewState: UserHomeViewState
    ) : ViewState

    sealed class UserHomeViewState {
        object Idle : UserHomeViewState()
        object Loading : UserHomeViewState()
        data class UserInfoSuccess(val userName: String?, val publicKey: String?): UserHomeViewState()
        data class NewMessage(val conversationItemList: ConversationListItemModel): UserHomeViewState()
        data class GetCachedConversationItemsList(val conversationItemList: MutableList<ConversationListItemModel>): UserHomeViewState()
    }

    sealed class Effect : ViewEffect {
        data class ShowServerErrorToast(val message: String?) : Effect()
    }
}