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

import com.doaa.anonymouschat.data.cache.EncryptedSharedPreferenceRepository
import com.doaa.anonymouschat.data.socket.SocketBuilder
import com.doaa.anonymouschat.domain.entities.messaging.Message
import com.doaa.anonymouschat.presentation.base.BaseViewModel
import com.google.gson.Gson
import com.goterl.lazysodium.LazySodiumAndroid
import com.goterl.lazysodium.SodiumAndroid
import com.goterl.lazysodium.interfaces.Box
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

    private val lazySodium by lazy { LazySodiumAndroid(SodiumAndroid()) }

    private val socket by lazy { socketBuilder.socketObject }

    val aliceKp: KeyPair = lazySodium.cryptoBoxKeypair()
    val bobKp: KeyPair = lazySodium.cryptoBoxKeypair()
    val nonce: ByteArray = lazySodium.nonce(Box.NONCEBYTES)

    private val onNotificationReceived: Emitter.Listener = Emitter.Listener { array ->
        array?.let {
            if (array.isNotEmpty()) {
                val data = it[0].toString()
                val message =  Gson().fromJson(data, Message::class.java)
                val aliicce = Key.fromHexString(sharedPreferenceRepository.getPublicKey())
                val boob = Key.fromHexString(sharedPreferenceRepository.getPublicKey())

                val bobFromAliceKp = KeyPair(aliceKp.getPublicKey(), bobKp.getSecretKey())
                val decrypted: String = lazySodium.cryptoBoxOpenEasy(message.encryptedMessage, nonce, bobFromAliceKp)


               // val aliceToBobKp = KeyPair(sharedPreferenceRepository.getPublicKey(), sharedPreferenceRepository.getPublicKey())
              //  val bobFromAliceKp = KeyPair(aliceKp.publicKey, bobKp.secretKey)
             //   val nonce: ByteArray = sodium.nonce(Box.NONCEBYTES)
              //  val decrypted: String = sodium.cryptoBoxOpenEasy(message.encryptedMessage, nonce, bobFromAliceKp)
             //   Log.d("DECRYPTEDYAM3LM", "decrypteddata" + decrypted)
                //   showRedCarpetNotification(array[0].toString())

            }
        }

    }

    private val onConnect: Emitter.Listener = Emitter.Listener {
        android.util.Log.d("socket landing", "connected...")
    }

    private val onConnecting: Emitter.Listener = Emitter.Listener {
        android.util.Log.d("socket landing", "connecting")
    }

    private val onConnectError: Emitter.Listener =
        Emitter.Listener {
            android.util.Log.d("socket landing", "Error connecting...") }

    init {
        socket?.let { mSocket ->
                mSocket.connect()

          socket?.on("chat message", onNotificationReceived)
            mSocket.on(Socket.EVENT_CONNECT, onConnecting);
            mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        }
    }

    override fun createInitialState(): ConversationContract.State {
        return ConversationContract.State(ConversationContract.ConversationViewState.Idle)
    }

    override suspend fun handleIntent(intent: ConversationContract.Intent) {
        when (intent) {
            is ConversationContract.Intent.InitConversation -> {
                conversationPublicKey = intent.publicKey
            }

            is ConversationContract.Intent.SendMessage -> {
                sendMessage(intent.message)
            }
        }
    }

    private fun sendMessage(body: String?) {
     }

    override fun onCleared() {
        socket?.let { mSocket ->
        }
        super.onCleared()
    }
}