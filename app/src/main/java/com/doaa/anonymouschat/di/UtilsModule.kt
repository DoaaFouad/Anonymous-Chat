/*
 * *
 * Created by Doaa Fouad on 1/17/22 11:35 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 11:35 PM
 *
 */

package com.doaa.anonymouschat.di

import com.doaa.anonymouschat.presentation.main.conversation.ConversationAdapter
import com.emc.voicenote.room.DatabaseBuilder
import com.emc.voicenote.room.DatabaseInteractor
import org.koin.dsl.module

val utilsModule = module {

    single {
        ConversationAdapter()
    }

    single { DatabaseBuilder.buildRoomDB(get()) }
    single { DatabaseInteractor(get()) }
}