/*
 * *
 * Created by Doaa Fouad on 1/17/22 11:34 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 11:34 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.conversation

import android.R.id.message
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.doaa.anonymouschat.databinding.RowChatRecievedBinding
import com.doaa.anonymouschat.databinding.RowChatSentBinding
import com.doaa.anonymouschat.domain.entities.messaging.Message


class ConversationAdapter() :
    RecyclerView.Adapter<BaseConversationViewHolder>() {

    private var messagesList: MutableList<Message> = arrayListOf()

    private val VIEW_TYPE_MESSAGE_SENT = 1
    private val VIEW_TYPE_MESSAGE_RECEIVED = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConversationViewHolder {
        val itemBinding : ViewBinding
        return if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            itemBinding =
                RowChatSentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            SentMessageChatViewHolder(itemBinding)
        } else{
            itemBinding =
                RowChatRecievedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ReceivedMessageChatViewHolder(itemBinding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if ((messagesList[position]).isSent == true) {
            VIEW_TYPE_MESSAGE_SENT
        } else {
            VIEW_TYPE_MESSAGE_RECEIVED
        }
    }

    override fun onBindViewHolder(holder: BaseConversationViewHolder, position: Int) {
        when(holder.itemViewType){
            VIEW_TYPE_MESSAGE_SENT -> {
                (holder as SentMessageChatViewHolder).initRow(messagesList[position])
            }
            else -> {
                (holder as ReceivedMessageChatViewHolder).initRow(messagesList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }


    fun setData(messagesData: MutableList<Message>?) {
        messagesData?.let {
            messagesList = messagesData
        }
        notifyDataSetChanged()
    }

    fun addToData(message: Message) {
        messagesList.add(0, message)
        notifyItemInserted(0)
    }
}

