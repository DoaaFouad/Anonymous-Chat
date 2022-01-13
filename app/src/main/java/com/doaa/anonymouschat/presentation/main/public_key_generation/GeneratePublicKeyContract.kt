/*
 * *
 * Created by Doaa Fouad on 1/13/22 10:54 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/13/22 10:54 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.public_key_generation

import com.doaa.anonymouschat.domain.entities.crypto.KeyPairResult
import com.doaa.anonymouschat.presentation.base.ViewEffect
import com.doaa.anonymouschat.presentation.base.ViewIntent
import com.doaa.anonymouschat.presentation.base.ViewState

class GeneratePublicKeyContract {

    sealed class Intent : ViewIntent {
      //  data class RegisterPublicKey() : Intent()
        object GeneratePublicKey : Intent()
    }

    data class State (
        val generatePublicKeyViewState: GeneratePublicKeyViewState
    ) : ViewState

    sealed class GeneratePublicKeyViewState {
        object Idle : GeneratePublicKeyViewState()
        object Loading : GeneratePublicKeyViewState()
        data class GeneratePublicKeySuccess(val keyPairResult: KeyPairResult?) : GeneratePublicKeyViewState()
    }

    sealed class Effect : ViewEffect {
        data class ShowServerErrorToast(val message: String) : Effect()
    }
}