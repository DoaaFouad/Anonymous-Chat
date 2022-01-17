/*
 * *
 * Created by Doaa Fouad on 1/15/22 12:59 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/15/22 12:59 PM
 *
 */

package com.doaa.anonymouschat.domain.entities.status

sealed class Error(message: String) : Exception(message) {
    object Generic : Error("An error occurred.")
    object ParsingFailed : Error("Invalid response.")
    object DecryptionFailed : Error("Couldn't decrypt response.")
    object SigningFailed : Error("Couldn't sign message.")
    object InvalidURL : Error("Invalid URL.")
    object NoPublicKey : Error("Couldn't find server public key.")
}