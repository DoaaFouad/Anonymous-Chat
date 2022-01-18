/*
 * *
 * Created by Doaa Fouad on 1/18/22 6:52 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/18/22 6:52 AM
 *
 */

package com.doaa.anonymouschat.data.repositories

import com.doaa.anonymouschat.domain.entities.messaging.ConversationListItemModel
import com.doaa.data.mappers.Mappers.conversationItemMapper
import com.emc.voicenote.room.DatabaseInteractor
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class ConversationItemListRepository(
    private val databaseHelper: DatabaseInteractor
): BaseRepository() {

    suspend fun addToConversationItemList(conversationListItemModel: ConversationListItemModel): Deferred<Unit> =
        withContext(dispatcherIO) {
            async {
                databaseHelper.addConversationItem(conversationItemMapper.mapFromItem(conversationListItemModel))
            }
        }

    suspend fun getConversationItemList(): Deferred<List<ConversationListItemModel>> =
        withContext(dispatcherIO) {
            async {
                val favoriteDetailsList = databaseHelper.getConversationItemList()
                favoriteDetailsList.map {
                    conversationItemMapper.mapToItem(it)
                }

            }
        }

}