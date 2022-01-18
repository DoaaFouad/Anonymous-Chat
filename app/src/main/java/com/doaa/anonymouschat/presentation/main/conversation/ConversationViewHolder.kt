/*
 * *
 * Created by Doaa Fouad on 1/18/22 12:04 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/18/22 12:04 AM
 *
 */

package com.doaa.anonymouschat.presentation.main.conversation

import androidx.recyclerview.widget.RecyclerView
import com.doaa.anonymouschat.databinding.RowChatRecievedBinding
import com.doaa.anonymouschat.databinding.RowChatSentBinding
import com.doaa.anonymouschat.domain.entities.messaging.Message


class SentMessageChatViewHolder(
    val rowBinding: RowChatSentBinding
) :
    BaseConversationViewHolder(rowBinding) {

    fun initRow(model: Message) {
        rowBinding.tvMessage?.text = model.decryptedMessage
    }
}

class ReceivedMessageChatViewHolder(
    val rowBinding: RowChatRecievedBinding
) :
    BaseConversationViewHolder(rowBinding) {

    fun initRow(model: Message) {
        rowBinding.tvMessage?.text = model.decryptedMessage
    }
}

class SentMessageHolder internal constructor(val rowBinding: RowChatSentBinding) :
    RecyclerView.ViewHolder(rowBinding.root) {

    fun initRow(model: Message) {
        rowBinding.tvMessage?.text = model.decryptedMessage
    }
}