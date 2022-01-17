/*
 * *
 * Created by Doaa Fouad on 1/17/22 8:39 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/17/22 8:39 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.user_home

import androidx.lifecycle.lifecycleScope
import com.doaa.anonymouschat.R
import com.doaa.anonymouschat.databinding.ActivityUserHomeBinding
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.presentation.main.join_chat.JoinChatActivity
import com.doaa.anonymouschat.utils.copyPublicKeyToClipBoard
import com.doaa.anonymouschat.utils.sharePublicKey
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserHomeActivity :
    BaseActivity<UserHomeContract.Intent, UserHomeContract.State, UserHomeContract.Effect, ActivityUserHomeBinding>() {

    override val viewModel by viewModel<UserHomeViewModel>()

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.userHomeViewState) {
                    is UserHomeContract.UserHomeViewState.Idle -> {

                    }

                    is UserHomeContract.UserHomeViewState.UserInfoSuccess -> {
                        initUserInfo(state.userName, state.publicKey)
                    }
                }

            }
        }
    }

    override fun init() {
        super.init()

        viewModel.setIntent(UserHomeContract.Intent.GetUserInfo)
    }
    override fun setListeners() {
        super.setListeners()

        binding?.ivCopy?.setOnClickListener {
            copyPublicKeyToClipBoard("Public Key", binding?.tvPublicKey?.text.toString())
            showLongToast(getString(R.string.public_key_generation_copy_success))
        }

        binding?.ivShare?.setOnClickListener {
            sharePublicKey(binding?.tvPublicKey?.text.toString())
        }

        binding?.ivAddChat?.setOnClickListener {
            navigateToActivity(JoinChatActivity::class.java)
        }
    }

    private fun initUserInfo(userName: String?, publicKey: String?){
        binding?.tvAnonymousName?.text = userName
        binding?.tvPublicKey?.text = publicKey
    }

    override fun getViewBinding(): ActivityUserHomeBinding {
        return ActivityUserHomeBinding.inflate(layoutInflater)
    }
}