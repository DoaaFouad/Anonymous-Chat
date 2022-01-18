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
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val GLIDE = "4.11.0"

    // Architecture Component
    const val ARCH_COMPONENT = "2.2.0"
    const val ARCH_COMPONENT_LIFECYCLE = "2.3.1"

    // DI
    const val KOIN = "2.0.1"
    const val KOIN_ANDROID = "2.0.1"

    // Asynchronous
    const val COROUTINES_CORE = "1.4.3"
    const val COROUTINES_ANDROID = "1.4.0"
    const val KOVENANT = "3.3.0"
    const val KOVENANT_ANDROID = "3.3.0"

    // Cryptography
    const val LAZY_SODIUM = "5.1.1"
    const val LAZY_SODIUM_JNA = "5.10.0"
    const val LAZY_SODIUM_ANDROID = "5.0.2"
    const val LAZY_SODIUM_JNA_ANDROID = "5.10.0"
    const val SIGNAL_PROTOCOL = "2.3.0"
    const val ANDROIDX_SECURITY = "1.1.0-alpha03"
    const val CURVE_25519 = "0.2.5"
    const val PROTO_BUF = "3.5.1"

    // Networking
    const val RETROFIT = "2.7.1"
    const val RETROFIT_CONVERTOR = "2.6.2"
    const val RETROFIT_RXJAVA = "2.6.2"
    const val OKHTTP = "3.12.1"
    const val SOCKET_IO = "2.0.0"
    const val GSON = "2.8.6"

    //Data
    const val ROOM = "2.2.6"

    // Parsing
    const val JACKSON_DATABIND = "2.12.4"
}

object Libraries {
    // Kotlin
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    // UI
    const val ANDROID_X = "androidx.core:core-ktx:${Versions.ANDROID_X}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"

    // Architecture Components
    const val ARCH_COMPONENT = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ARCH_COMPONENT}"
    const val ARCH_COMPONENT_LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ARCH_COMPONENT_LIFECYCLE}"

    // DI
    const val KOIN = "org.koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "org.koin:koin-androidx-viewmodel:${Versions.KOIN_ANDROID}"

    // Asynchronous
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_CORE}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"
    const val KOVENANT = "nl.komponents.kovenant:kovenant:${Versions.KOVENANT}"
    const val KOVENANT_ANDROID = "nl.komponents.kovenant:kovenant-android:${Versions.KOVENANT_ANDROID}"

    // Cryptography
    const val LAZY_SODIUM = "com.goterl:lazysodium-java:${Versions.LAZY_SODIUM}"
    const val LAZY_SODIUM_JNA = "net.java.dev.jna:jna:${Versions.LAZY_SODIUM_JNA}"
    const val LAZY_SODIUM_ANDROID = "com.goterl:lazysodium-android:${Versions.LAZY_SODIUM_ANDROID}@aar"
    const val LAZY_SODIUM_JNA_ANDROID = "net.java.dev.jna:jna:${Versions.LAZY_SODIUM_JNA_ANDROID}@aar"
    const val SIGNAL_PROTOCOL = "org.whispersystems:signal-protocol-android:${Versions.SIGNAL_PROTOCOL}"
    const val ANDROIDX_SECURITY = "androidx.security:security-crypto:${Versions.ANDROIDX_SECURITY}"
    const val CURVE_25519 = "org.whispersystems:curve25519-java:${Versions.CURVE_25519}"
    const val PROTO_BUF = "com.google.protobuf:protobuf-java:${Versions.PROTO_BUF}"

    // Networking
    const val OKHTTP = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val JACKSON_DATABINDING = "com.fasterxml.jackson.core:jackson-databind:${Versions.JACKSON_DATABIND}"
    const val SOCKET_IO = "io.socket:socket.io-client:${Versions.SOCKET_IO}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    // Data
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"

}



