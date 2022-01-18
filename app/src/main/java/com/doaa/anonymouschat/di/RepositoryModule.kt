/*
 * *
 * Created by Doaa Fouad on 1/15/22 5:50 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/15/22 5:50 PM
 *
 */

package com.doaa.anonymouschat.di

import android.content.Context
import com.doaa.anonymouschat.data.repositories.EncryptedSharedPreferenceRepository
import com.doaa.anonymouschat.data.cache.EncryptedSharedPreferencesWrapper
import com.doaa.anonymouschat.data.repositories.ConversationItemListRepository
import com.doaa.anonymouschat.data.socket.SocketBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single { EncryptedSharedPreferenceRepository(get()) }
    single { ConversationItemListRepository(get()) }
    single {
        EncryptedSharedPreferencesWrapper(
            encryptedSharedPreferences = this.androidContext().getSharedPreferences(
                "AnonymousChat",
                Context.MODE_PRIVATE,
            ), get()
        )
    }

    single {
        SocketBuilder()
    }
}