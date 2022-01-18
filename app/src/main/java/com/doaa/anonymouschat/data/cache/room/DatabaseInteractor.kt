/*
 * Created by Doaa Fouad on 4/19/21 2:20 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 *
 * Last modified 4/19/21 2:20 AM
 */

package com.emc.voicenote.room

import com.doaa.data.cache.room.favorite.ConversationItem


class DatabaseInteractor(val appDatabase: AppDatabase) : IDatabaseInteractor {

    override suspend fun getConversationItemList(): MutableList<ConversationItem> = appDatabase.conversationItemDao().get()
    override suspend fun addConversationItem(conversationItem: ConversationItem) = appDatabase.conversationItemDao().add(conversationItem)
}