/*
 * *
 * Created by Doaa Fouad on 1/18/22 6:52 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/18/22 6:52 AM
 *
 */

package com.doaa.anonymouschat.data.repositories

import kotlinx.coroutines.Dispatchers

abstract class BaseRepository {
    protected var dispatcherIO = Dispatchers.IO
}