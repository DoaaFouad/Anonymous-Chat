/*
 * *
 * Created by Doaa Fouad on 1/14/22 2:31 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 2:31 AM
 *
 */

package com.doaa.anonymouschat.di

import com.doaa.anonymouschat.presentation.main.conversation.ConversationViewModel
import com.doaa.anonymouschat.presentation.main.join_chat.JoinChatViewModel
import com.doaa.anonymouschat.presentation.main.public_key_generation.GeneratePublicKeyViewModel
import com.doaa.anonymouschat.presentation.main.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel(get()) }
    viewModel { GeneratePublicKeyViewModel(get()) }
    viewModel { JoinChatViewModel() }
    viewModel { ConversationViewModel(get(), get()) }
}
