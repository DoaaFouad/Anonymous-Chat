/*
 * *
 * Created by Doaa Fouad on 1/14/22 5:30 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 5:30 PM
 *
 */

package com.doaa.anonymouschat.domain.entities.messaging

import com.doaa.anonymouschat.data.socket.SocketRemoteModel
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("sender_public_key")
    var senderPublicKey: String? = null,

    @SerializedName("receiver_public_Key")
    var receivePublicKey: String? = null,

    @SerializedName("encrypted_message")
    var encryptedMessage: String? = null,

    var isSent: Boolean? = null,

    var decryptedMessage: String? = null

){

    fun convertToJsonString(): String? {
        return Gson().toJson(this)
    }
}
