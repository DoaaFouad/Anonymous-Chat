/*
 * *
 * Created by Doaa Fouad on 1/17/22 7:09 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 7:09 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.splash

import com.doaa.anonymouschat.presentation.base.ViewEffect
import com.doaa.anonymouschat.presentation.base.ViewIntent
import com.doaa.anonymouschat.presentation.base.ViewState

class SplashContract {

    sealed class Intent : ViewIntent {
        object CheckNavigationFlow : Intent()
    }

    data class State(
        val splashViewState: SplashViewState
    ) : ViewState

    sealed class SplashViewState {
        object Idle : SplashViewState()
        object Loading : SplashViewState()
        data class NavigationFLow(val navigation: Navigation): SplashViewState()
    }

    sealed class Effect : ViewEffect {
        data class ShowServerErrorToast(val message: String) : Effect()
    }
}