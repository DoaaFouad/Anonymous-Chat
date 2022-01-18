/*
 * Created by Doaa Fouad on 4/19/21 2:13 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 *
 * Last modified 4/19/21 2:13 AM
 */

package com.emc.voicenote.room

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {

    fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "anonymous-chat"
        ).build()

}