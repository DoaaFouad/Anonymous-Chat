/*
 * *
 * Created by Doaa Fouad on 1/17/22 8:39 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 8:39 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.user_home

import com.doaa.anonymouschat.data.cache.EncryptedSharedPreferenceRepository
import com.doaa.anonymouschat.data.socket.SocketBuilder
import com.doaa.anonymouschat.data.socket.SocketEvents
import com.doaa.anonymouschat.domain.entities.messaging.ConversationListItem
import com.doaa.anonymouschat.domain.entities.messaging.Message
import com.doaa.anonymouschat.presentation.base.BaseViewModel
import com.doaa.anonymouschat.presentation.main.conversation.ConversationContract
import com.google.gson.Gson
import com.goterl.lazysodium.utils.Key
import com.goterl.lazysodium.utils.KeyPair
import io.socket.client.Socket
import io.socket.emitter.Emitter

class UserHomeViewModel(
    val sharedPreferenceRepository: EncryptedSharedPreferenceRepository,
    val socketBuilder: SocketBuilder
) :
    BaseViewModel<UserHomeContract.Intent, UserHomeContract.State, UserHomeContract.Effect>() {

    private val socket by lazy { socketBuilder.socketObject }

    private var myPublicKey: Key? = null
    private var myPrivateKey: Key? = null

    override fun createInitialState(): UserHomeContract.State {
        return UserHomeContract.State(UserHomeContract.UserHomeViewState.Idle)
    }

    override suspend fun handleIntent(intent: UserHomeContract.Intent) {
        when (intent) {
            is UserHomeContract.Intent.GetUserInfo -> {
                getUserInfo()
            }
        }
    }

    private val onConnectError: Emitter.Listener =
        Emitter.Listener {}

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

                } else {
                    val senderPublicKey = Key.fromHexString(message.senderPublicKey)
                    val decryptKeyPair = KeyPair(senderPublicKey, myPrivateKey)
                    //      val decryptedMessage: String = lazySodium.cryptoBoxOpenEasy(message.encryptedMessage, nonce, decryptKeyPair)

                    message.isSent = false
                    message.decryptedMessage = message.encryptedMessage //decryptedMessage

                    setState {
                        copy(
                            userHomeViewState = UserHomeContract.UserHomeViewState.NewMessage(
                                ConversationListItem(
                                    identifierName = message.senderPublicKey,
                                    lastMessage = message
                                )
                            )
                        )
                    }
                }
            }
        }

    }

    init {
        connectToSocket()
        myPublicKey = getMyPublicKey()
        myPrivateKey = getMyPrivateKey()
    }

    private fun getUserInfo() {
        val userName = sharedPreferenceRepository.getUserName()
        val publicKey = sharedPreferenceRepository.getPublicKey()

        setState {
            copy(
                userHomeViewState = UserHomeContract.UserHomeViewState.UserInfoSuccess(
                    userName = userName,
                    publicKey = publicKey
                )
            )
        }

    }

    private fun connectToSocket() {
        socket?.let { mSocket ->
            mSocket.on(SocketEvents.SOCKET_CHAT_MESSAGE, onChatMessageReceived)
            mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError)

            mSocket.connect()
        }
    }

    private fun getMyPublicKey(): Key {
        return Key.fromHexString(sharedPreferenceRepository.getPublicKey())
    }

    private fun getMyPrivateKey(): Key {
        return Key.fromHexString(sharedPreferenceRepository.getPrivateKey())
    }
}