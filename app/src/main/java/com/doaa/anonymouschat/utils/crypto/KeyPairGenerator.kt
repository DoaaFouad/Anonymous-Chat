/*
 * *
 * Created by Doaa Fouad on 1/14/22 1:52 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 1:34 AM
 *
 */

package com.doaa.anonymouschat.utils

import com.doaa.anonymouschat.domain.entities.crypto.KeyPairResult
import com.doaa.anonymouschat.domain.entities.crypto.PrivateKey
import com.doaa.anonymouschat.domain.entities.crypto.PublicKey
import com.goterl.lazysodium.LazySodiumAndroid
import com.goterl.lazysodium.SodiumAndroid
import org.whispersystems.libsignal.ecc.ECKeyPair

object KeyPairGenerator {

   private val sodium by lazy { LazySodiumAndroid(SodiumAndroid()) }

   fun generate() : KeyPairResult? {
      val seed = sodium.randomBytesBuf(16)
      return  KeyPairResult(seed, sodium.cryptoBoxKeypair())
     /* return try {
         val padding = ByteArray(16) { 0 }
         val ed25519KeyPair = sodium.cryptoBoxKeypair() // sodium.cryptoSignSeedKeypair(seed + padding)
         val sodiumX25519KeyPair = sodium.convertKeyPairEd25519ToCurve25519(ed25519KeyPair)
        // val x25519KeyPair = ECKeyPair(PublicKey(sodiumX25519KeyPair.publicKey.asBytes), PrivateKey(sodiumX25519KeyPair.secretKey.asBytes))
         KeyPairResult(seed, ed25519KeyPair)
      } catch (exception: Exception) {
         null
      }*/
   }

}