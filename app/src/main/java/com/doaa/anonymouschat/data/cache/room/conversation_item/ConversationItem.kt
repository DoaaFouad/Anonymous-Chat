/*
 *
 * Created by doaafouad on 1/16/22 10:05 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 10:05 PM
 *
 *
 */

package com.doaa.data.cache.room.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["identifier"], unique = true)])
data class ConversationItem(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "identifier") var identifier: String? = "",
    @ColumnInfo(name = "last_message") var lastMessage: String? = "",
)