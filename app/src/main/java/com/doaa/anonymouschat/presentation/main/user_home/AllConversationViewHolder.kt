/*
 * *
 * Created by Doaa Fouad on 1/18/22 5:45 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/18/22 5:45 AM
 *
 */

package com.doaa.anonymouschat.presentation.main.user_home

import androidx.recyclerview.widget.RecyclerView
import com.doaa.anonymouschat.databinding.RowAllConversationsBinding
import com.doaa.anonymouschat.domain.entities.messaging.ConversationListItem

class AllConversationViewHolder(
    val rowBinding: RowAllConversationsBinding,
    val listener: AllConversationsListener
) :
    RecyclerView.ViewHolder(rowBinding.root) {

    fun initRow(model: ConversationListItem) {
        rowBinding.tvIdentifier.text = model.identifierName
        rowBinding.tvMessage.text = model.lastMessage?.decryptedMessage

        rowBinding.root.setOnClickListener {
            listener.onItemClicked(model.identifierName, model.lastMessage?.decryptedMessage)
        }
    }
}
