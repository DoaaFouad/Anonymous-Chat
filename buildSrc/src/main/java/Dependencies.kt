/*
 *
 * Created by Doaa Fouad on 1/13/22 9:58 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/13/22 9:53 PM
 *
 */

object BuildConfigs {
    const val APPLICATION_ID = "com.doaa.anonymouschat"

    const val COMPILE_SDK = 30
    const val MIN_SDK = 24
    const val TARGET_SDK = 30
    const val BUILD_TOOLS_VERSION = "29.0.3"

    const val DEVELOPMENT_VERSION_CODE = 1
    const val DEVELOPMENT_VERSION_NAME = "1.0"
}

object Versions {
    // Kotlin
    const val KOTLIN = "1.3.72"

    // UI
    const val ANDROID_X = "1.3.2"
    const val APPCOMPAT = "1.2.0"
    const val MATERIAL = "1.1.0"
    const val GLIDE = "4.11.0"

    // Architecture Component
    const val ARCH_COMPONENT = "2.2.0"
    const val ARCH_COMPONENT_LIFECYCLE = "2.3.1"

    // DI
    const val KOIN = "2.0.1"
    const val KOIN_ANDROID = "2.0.1"

    //Coroutines
    const val COROUTINES_CORE = "1.4.3"
    const val COROUTINES_ANDROID = "1.4.0"
}

object Libraries {
    // Kotlin
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    // UI
    const val ANDROID_X = "androidx.core:core-ktx:${Versions.ANDROID_X}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"

    // Architecture Components
    const val ARCH_COMPONENT = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ARCH_COMPONENT}"
    const val ARCH_COMPONENT_LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ARCH_COMPONENT_LIFECYCLE}"

    // DI
    const val KOIN = "org.koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "org.koin:koin-androidx-viewmodel:${Versions.KOIN_ANDROID}"

    // Coroutines
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_CORE}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"
}



