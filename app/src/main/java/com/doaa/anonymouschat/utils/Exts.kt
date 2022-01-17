/*
 * *
 * Created by Doaa Fouad on 1/17/22 8:15 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 8:15 PM
 *
 */

package com.doaa.anonymouschat.utils

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import com.doaa.anonymouschat.R


fun Activity.copyPublicKeyToClipBoard(label: String, text: String?){
    val clipboard: ClipboardManager =
        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, text)
    clipboard.setPrimaryClip(clip)
}

fun Activity.sharePublicKey(text: String?){
    val shareIntent = Intent()
    shareIntent.action = Intent.ACTION_SEND
    shareIntent.type="text/plain"
    shareIntent.putExtra(Intent.EXTRA_TEXT, text)
    startActivity(Intent.createChooser(shareIntent,getString(R.string.app_name)))
}