/*
 * *
 * Created by Doaa Fouad on 1/14/22 2:07 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 2:07 AM
 *
 */

package com.doaa.anonymouschat.domain.entities.crypto

import org.whispersystems.libsignal.ecc.Curve
import org.whispersystems.libsignal.ecc.DjbECPublicKey
import org.whispersystems.libsignal.ecc.ECPublicKey
import org.whispersystems.libsignal.util.ByteUtil
import java.math.BigInteger
import java.util.*

class PublicKey internal constructor(val publicKey: ByteArray) : ECPublicKey {
    override fun serialize(): ByteArray {
        val type = byteArrayOf(Curve.DJB_TYPE.toByte())
        return ByteUtil.combine(type, publicKey)
    }

    override fun getType(): Int {
        return Curve.DJB_TYPE
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is DjbECPublicKey) return false
        return Arrays.equals(publicKey, other.publicKey)
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(publicKey)
    }

    override fun compareTo(another: ECPublicKey): Int {
        return BigInteger(publicKey).compareTo(BigInteger((another as DjbECPublicKey).publicKey))
    }

}