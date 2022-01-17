/*
 * *
 * Created by Doaa Fouad on 1/17/22 7:22 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 7:22 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.splash

sealed class Navigation {
    object PublicKeyGeneration : Navigation()
    object UserHome : Navigation()
}