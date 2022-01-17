/*
 * *
 * Created by Doaa Fouad on 1/14/22 1:53 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 1:53 AM
 *
 */

package com.doaa.anonymouschat.domain.entities.crypto

import com.goterl.lazysodium.utils.KeyPair
import org.whispersystems.libsignal.ecc.ECKeyPair

data class KeyPairResult(
    val seed: ByteArray,
    val ed25519KeyPair: KeyPair,
    val x25519KeyPair: ECKeyPair //Curve25519
)