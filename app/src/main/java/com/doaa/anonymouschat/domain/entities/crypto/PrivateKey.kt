/*
 * *
 * Created by Doaa Fouad on 1/14/22 2:09 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 2:09 AM
 *
 */

package com.doaa.anonymouschat.domain.entities.crypto

import org.whispersystems.libsignal.ecc.Curve
import org.whispersystems.libsignal.ecc.ECPrivateKey

class PrivateKey internal constructor(val privateKey: ByteArray) : ECPrivateKey {

    override fun serialize(): ByteArray {
        return privateKey
    }

    override fun getType(): Int {
        return Curve.DJB_TYPE
    }

}
