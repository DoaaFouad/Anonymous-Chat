/*
 * *
 * Created by Doaa Fouad on 1/14/22 5:48 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 5:48 PM
 *
 */

package com.doaa.anonymouschat.data.cache

import com.doaa.anonymouschat.utils.constants.SharedPreferencesKeys

class EncryptedSharedPreferenceRepository(private val wrapper: EncryptedSharedPreferencesWrapper) {

    fun getPublicKey() =
        wrapper.getString(SharedPreferencesKeys.PUBLIC_KEY, "") ?: ""

    fun setPublicKey(publicKey: String) =
        wrapper.putString(SharedPreferencesKeys.PUBLIC_KEY, publicKey)

    fun getPrivateKey() =
        wrapper.getString(SharedPreferencesKeys.PRIVATE_KEY, "") ?: ""

    fun setPrivateKey(privateKey: String) =
        wrapper.putString(SharedPreferencesKeys.PRIVATE_KEY, privateKey)

    fun getUserName() =
        wrapper.getString(SharedPreferencesKeys.USER_NAME, "") ?: ""

    fun setUserName(userName: String) =
        wrapper.putString(SharedPreferencesKeys.USER_NAME, userName)

}