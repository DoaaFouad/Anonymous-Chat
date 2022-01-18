/*
 *
 * Created by doaafouad on 1/16/22 11:02 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 11:02 PM
 *
 *
 */

package com.doaa.data.mappers

import com.doaa.anonymouschat.domain.entities.messaging.ConversationListItemModel
import com.doaa.anonymouschat.domain.entities.messaging.Message
import com.doaa.data.cache.room.favorite.ConversationItem

class ConversationItemMapper :
    ItemMapper<ConversationItem?, ConversationListItemModel> {
    override fun mapFromItem(model: ConversationListItemModel): ConversationItem {
        return ConversationItem(
            uid = 0,
            identifier = model.identifierName,
            lastMessage = model.lastMessage?.decryptedMessage
        )
    }

    override fun mapToItem(model: ConversationItem?): ConversationListItemModel {
        return ConversationListItemModel(
            identifierName = model?.identifier,
            lastMessage = Message(decryptedMessage = model?.lastMessage)
        )
    }
}
