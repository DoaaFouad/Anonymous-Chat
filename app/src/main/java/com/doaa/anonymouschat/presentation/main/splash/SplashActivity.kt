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

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import com.doaa.anonymouschat.databinding.ActivitySplashBinding
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.presentation.main.public_key_generation.GeneratePublicKeyActivity
import com.doaa.anonymouschat.presentation.main.user_home.UserHomeActivity
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity :
    BaseActivity<SplashContract.Intent, SplashContract.State, SplashContract.Effect, ActivitySplashBinding>() {

    override val viewModel by viewModel<SplashViewModel>()

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.splashViewState) {
                    is SplashContract.SplashViewState.Idle -> {

                    }
                    is SplashContract.SplashViewState.NavigationFLow -> {
                        navigate(state.navigation)
                    }
                }

            }
        }
    }

    override fun init() {
        super.init()

        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.setIntent(SplashContract.Intent.CheckNavigationFlow)
        }, 1000)
    }

    private fun navigate(navigation: NavigationDestination) {
        when (navigation) {
            NavigationDestination.UserHome -> {
                navigateToActivity(UserHomeActivity::class.java)
                finish()
            }

            NavigationDestination.PublicKeyGeneration -> {
                navigateToActivity(GeneratePublicKeyActivity::class.java)
                finish()
            }
        }
    }

    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }
}