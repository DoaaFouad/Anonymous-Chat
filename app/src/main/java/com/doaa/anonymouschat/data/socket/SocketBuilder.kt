/*
 * *
 * Created by Doaa Fouad on 1/15/22 6:46 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/15/22 6:46 PM
 *
 */

package com.doaa.anonymouschat.data.socket

import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

class SocketBuilder() {

    private fun getSocket(): Socket? {
        return try {
            val socketUrl = "http://1c57-91-75-111-243.ngrok.io"
            Log.e("socket", socketUrl)
            var mSocket: Socket?
            mSocket = IO.socket(socketUrl)
            mSocket
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            null
        }
    }

    val socketObject: Socket? = getSocket()
}