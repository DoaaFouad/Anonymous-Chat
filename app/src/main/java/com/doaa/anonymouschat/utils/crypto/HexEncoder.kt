/*
 * *
 * Created by Doaa Fouad on 1/14/22 2:26 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 2:26 AM
 *
 */

package com.doaa.anonymouschat.utils.crypto

import org.whispersystems.libsignal.ecc.ECKeyPair

val ECKeyPair.hexEncodedPublicKey: String
    get() = publicKey.serialize().toHexString()

fun ByteArray.toHexString(): String {
    return joinToString("") { String.format("%02x", it) }
}