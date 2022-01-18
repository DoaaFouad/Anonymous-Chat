/*
 * *
 * Created by Doaa Fouad on 1/14/22 4:39 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 4:39 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.conversation

import com.doaa.anonymouschat.data.repositories.EncryptedSharedPreferenceRepository
import com.doaa.anonymouschat.data.socket.SocketBuilder
import com.doaa.anonymouschat.data.socket.SocketEvents
import com.doaa.anonymouschat.domain.entities.messaging.Message
import com.doaa.anonymouschat.presentation.base.BaseViewModel
import com.google.gson.Gson
import com.goterl.lazysodium.LazySodiumAndroid
import com.goterl.lazysodium.SodiumAndroid
import com.goterl.lazysodium.utils.Key
import com.goterl.lazysodium.utils.KeyPair
import io.socket.client.Socket
import io.socket.emitter.Emitter

class ConversationViewModel(
    val sharedPreferenceRepository: EncryptedSharedPreferenceRepository,
    val socketBuilder: SocketBuilder
) :
    BaseViewModel<ConversationContract.Intent, ConversationContract.State, ConversationContract.Effect>() {

    private lateinit var conversationPublicKey: String
    private var myPublicKey: Key? = null
    private var myPrivateKey: Key? = null

    private val lazySodium by lazy { LazySodiumAndroid(SodiumAndroid()) }

    private val socket by lazy { socketBuilder.socketObject }

    private val onConnectError: Emitter.Listener =
        Emitter.Listener {

        }

    override fun createInitialState(): ConversationContract.State {
        return ConversationContract.State(ConversationContract.ConversationViewState.Idle)
    }

    override suspend fun handleIntent(intent: ConversationContract.Intent) {
        when (intent) {
            is ConversationContract.Intent.InitConversation -> {
                conversationPublicKey = intent.publicKey
                myPublicKey = getMyPublicKey()
                myPrivateKey = getMyPrivateKey()
            }

            is ConversationContract.Intent.SendMessage -> {
                sendMessage(intent.message)
            }
        }
    }

    private val onChatMessageReceived: Emitter.Listener = Emitter.Listener { array ->
        array?.let {
            if (array.isNotEmpty()) {
                val data = it[0].toString()
                val message = Gson().fromJson(data, Message::class.java)

                if (message.senderPublicKey == myPublicKey?.asHexString) {
                    val senderPublicKey = Key.fromHexString(message.senderPublicKey)
                    val decryptKeyPair = KeyPair(senderPublicKey, myPrivateKey)
                    //  val decryptedMessage: String = lazySodium.cryptoBoxOpenEasy(message.encryptedMessage, nonce, decryptKeyPair)

                    message.isSent = true
                    message.decryptedMessage = message.encryptedMessage //decryptedMessage

                    setState {
                        copy(
                            conversationViewState = ConversationContract.ConversationViewState.NewMessage(
                                message
                            )
                        )
                    }

                } else {
                    val senderPublicKey = Key.fromHexString(message.senderPublicKey)
                    val decryptKeyPair = KeyPair(senderPublicKey, myPrivateKey)
                    //      val decryptedMessage: String = lazySodium.cryptoBoxOpenEasy(message.encryptedMessage, nonce, decryptKeyPair)

                    message.isSent = false
                    message.decryptedMessage = message.encryptedMessage //decryptedMessage

                    setState {
                        copy(
                            conversationViewState = ConversationContract.ConversationViewState.NewMessage(
                                message
                            )
                        )
                    }
                }
            }
        }

    }

    init {
        socket?.let { mSocket ->
            mSocket.on(SocketEvents.SOCKET_CHAT_MESSAGE, onChatMessageReceived)
            mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError)

            mSocket.connect()
        }
    }

    private fun sendMessage(body: String?) {

        val senderPublicKey = myPublicKey?.asHexString
        val receiverPublicKey = conversationPublicKey

        val otherPublicKey = Key.fromHexString(conversationPublicKey)
        val myPrivateKey = Key.fromHexString(sharedPreferenceRepository.getPrivateKey())
        val sentKeyPair = KeyPair(
            otherPublicKey,
            myPrivateKey
        ) // encrypt with other's public key using my secret key

        // val encrypted: String = lazySodium.cryptoBoxEasy(body, nonce, sentKeyPair)

        val message = Message(
            senderPublicKey = senderPublicKey,
            receivePublicKey = receiverPublicKey,
            encryptedMessage = body
        )

        socket?.emit(SocketEvents.SOCKET_CHAT_MESSAGE, message.convertToJsonString())
    }

    private fun getMyPublicKey(): Key {
        return Key.fromHexString(sharedPreferenceRepository.getPublicKey())
    }

    private fun getMyPrivateKey(): Key {
        return Key.fromHexString(sharedPreferenceRepository.getPrivateKey())
    }

    override fun onCleared() {
        socket?.let { mSocket ->
        }
        super.onCleared()
    }
}