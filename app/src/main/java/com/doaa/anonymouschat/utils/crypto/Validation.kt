/*
 * *
 * Created by Doaa Fouad on 1/14/22 4:20 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 4:20 PM
 *
 */

package com.doaa.anonymouschat.utils.crypto

object Validation {

    fun isPublicKeyValid(candidate: String, isPrefixRequired: Boolean): Boolean {
        val hexCharacters = "0123456789ABCDEF".toSet()
        val isValidHexEncoding = hexCharacters.containsAll(candidate.toUpperCase().toSet())
        val hasValidLength = candidate.length == 66 // constant?
        val hasValidPrefix = if (isPrefixRequired) candidate.startsWith("05") else true
        return isValidHexEncoding && hasValidLength && hasValidPrefix
    }

}