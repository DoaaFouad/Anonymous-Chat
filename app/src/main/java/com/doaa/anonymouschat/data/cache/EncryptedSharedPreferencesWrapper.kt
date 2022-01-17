/*
 * *
 * Created by Doaa Fouad on 1/14/22 5:33 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 5:33 PM
 *
 */

package com.doaa.anonymouschat.data.cache

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

open class EncryptedSharedPreferencesWrapper(
    var encryptedSharedPreferences: SharedPreferences,
    val appContext: Context
) {
    init {
        val masterKey = MasterKey.Builder(appContext)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        encryptedSharedPreferences = EncryptedSharedPreferences.create(
            appContext,
            "anonymous_chat",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    open fun getString(name: String, defVal: String): String? =
        encryptedSharedPreferences.getString(name, defVal)

    open fun putString(name: String, value: String) =
        encryptedSharedPreferences.edit().putString(name, value).apply()

    open fun getInt(name: String, defVal: Int): Int? =
        encryptedSharedPreferences.getInt(name, defVal)

    open fun putInt(name: String, value: Int) =
        encryptedSharedPreferences.edit().putInt(name, value).apply()
}