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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doaa.anonymouschat.databinding.RowAllConversationsBinding
import com.doaa.anonymouschat.domain.entities.messaging.ConversationListItem

class AllConversationsAdapter(val allConversationsListener: AllConversationsListener) :
    RecyclerView.Adapter<AllConversationViewHolder>() {

    private var conversationList: MutableList<ConversationListItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllConversationViewHolder {
        val itemBinding =
            RowAllConversationsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllConversationViewHolder(itemBinding, allConversationsListener)
    }

    override fun getItemCount(): Int {
        return conversationList.size
    }

    override fun onBindViewHolder(holder: AllConversationViewHolder, position: Int) {
        return holder.initRow(conversationList[position])
    }

    fun setData(conversationListData: MutableList<ConversationListItem>?) {
        conversationListData?.let {
            conversationList = conversationListData
        }
        notifyDataSetChanged()
    }

    fun addToData(item: ConversationListItem) {
        conversationList.add(0, item)
        notifyItemInserted(0)
    }
}