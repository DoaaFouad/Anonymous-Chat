/*
 * *
 * Created by Doaa Fouad on 1/14/22 2:34 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 2:34 AM
 *
 */

package com.doaa.anonymouschat

import android.app.Application
import com.doaa.anonymouschat.di.repositoryModule
import com.doaa.anonymouschat.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class AnonymousChatApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidLogger()
            androidContext(this@AnonymousChatApplication)
            modules(listOf(viewModelModule, repositoryModule))
        }
    }

}