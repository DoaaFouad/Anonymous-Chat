/*
 * *
 * Created by Doaa Fouad on 1/18/22 5:49 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/18/22 5:49 AM
 *
 */

package com.doaa.anonymouschat.domain.entities.messaging

data class ConversationListItem(
    var identifierName: String? = null,
    var lastMessage: Message? = null
)