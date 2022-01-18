/*
 *
 * Created by doaafouad on 1/16/22 3:59 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/16/22 3:59 PM
 *
 *
 */

package com.doaa.data.mappers

import com.doaa.anonymouschat.domain.entities.ItemModel

/**
 * Maps between remote model to item model and vice versa
 * */
interface ItemMapper<Remote, Item : ItemModel> {
    fun mapFromItem(model: Item): Remote
    fun mapToItem(model: Remote): Item
}