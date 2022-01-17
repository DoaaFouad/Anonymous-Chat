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
import org.whispersystems.curve25519.Curve25519

data class Message(
   /* val conversationPublicKey: String,
    val senderPublicKey: String?,
    val timeStamp: Long,
    val serverID: Long?,
    var recipient: String? = null,*/
  /*  @SerializedName("name")
    var name: String?= null,*/

    @SerializedName("sender_public_key")
    var senderPublicKey: String?= null,

    @SerializedName("receiver_public_Key")
    var receivePublicKey: String?= null,

    @SerializedName("encrypted_message")
    var encryptedMessage: String? = null,
    /**
     * The serialized protobuf in base64 encoding.
     */
  //  val base64EncodedData: String,
    /**
     * When sending a message, the sender signs the serialized protobuf with their private key so that
     * a receiving user can verify that the message wasn't tampered with.
     */
 //   val base64EncodedSignature: String? = null
): SocketRemoteModel {

    companion object {
  //      private val curve = Curve25519.getInstance(Curve25519.BEST)


    /*    fun fromJSON(json: Array<String, Any>): Message? {
            Gson().fromJson(json, Message::class.java)
            val base64EncodedData = json["data"] as? String ?: return null
            val sentTimestamp = json["timestamp"] as? Long ?: return null
            val serverID = json["server_id"] as? Int
            val sender = json["public_key"] as? String
            val base64EncodedSignature = json["signature"] as? String
            return Message(
                serverID = serverID?.toLong(),
                conversationPublicKey = "",
                senderPublicKey = sender,
                timeStamp = sentTimestamp,
                base64EncodedData = base64EncodedData,
                base64EncodedSignature = base64EncodedSignature
            )
        }*/

    }

   /* fun sign(): Message? {
        if (base64EncodedData.isEmpty()) return null
        val (publicKey, privateKey) = MessagingModuleConfiguration.shared.storage.getUserX25519KeyPair().let { it.publicKey to it.privateKey }
        if (senderPublicKey != publicKey.serialize().toHexString()) return null
        val signature = try {
            curve.calculateSignature(privateKey.serialize(), decode(base64EncodedData))
        } catch (e: Exception) {
            return null
        }
        return copy(base64EncodedSignature = Base64.encodeBytes(signature))
    }

    fun toJSON(): Map<String, Any> {
        val json = mutableMapOf( "data" to base64EncodedData, "timestamp" to timeStamp )
        serverID?.let { json["server_id"] = it }
        senderPublicKey?.let { json["public_key"] = it }
        base64EncodedSignature?.let { json["signature"] = it }
        return json
    }

    fun toProto(): SignalServiceProtos.Content {
        val data = decode(base64EncodedData).let(PushTransportDetails::getStrippedPaddingMessageBody)
        return SignalServiceProtos.Content.parseFrom(data)
    }*/
}
