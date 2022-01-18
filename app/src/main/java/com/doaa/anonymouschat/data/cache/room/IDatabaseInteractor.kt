/*
 * Created by Doaa Fouad on 4/19/21 2:21 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 *
 * Last modified 4/19/21 2:21 AM
 */

package com.emc.voicenote.room

import com.doaa.data.cache.room.favorite.ConversationItem

interface IDatabaseInteractor {
    suspend fun getConversationItemList(): List<ConversationItem>
    suspend fun addConversationItem(conversationItem: ConversationItem)
}