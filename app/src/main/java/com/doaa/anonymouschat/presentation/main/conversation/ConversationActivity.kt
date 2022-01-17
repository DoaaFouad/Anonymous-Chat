/*
 * *
 * Created by Doaa Fouad on 1/14/22 4:27 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 4:27 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.conversation

import androidx.lifecycle.lifecycleScope
import com.doaa.anonymouschat.R
import com.doaa.anonymouschat.databinding.ActivityConversationBinding
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.utils.constants.BundleKeys
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConversationActivity :
    BaseActivity<ConversationContract.Intent, ConversationContract.State, ConversationContract.Effect, ActivityConversationBinding>() {

    override val viewModel by viewModel<ConversationViewModel>()

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.conversationViewState) {
                    is ConversationContract.ConversationViewState.Idle -> {

                    }
                }

            }
        }
    }

    override fun setListeners() {
        super.setListeners()

        binding?.btnSend?.setOnClickListener {
            viewModel.setIntent(ConversationContract.Intent.SendMessage(binding?.etMessage?.text.toString()))
        }
    }

    override fun init() {
        super.init()

        val convPublicKey = intent.extras?.getString(BundleKeys.CONVERSATION_PUBLIC_KEY)
        convPublicKey?.let {
            viewModel.setIntent(ConversationContract.Intent.InitConversation(convPublicKey))
        }?: kotlin.run {
            showLongToast(getString(R.string.error))
        }
    }


    override fun getViewBinding(): ActivityConversationBinding {
        return ActivityConversationBinding.inflate(layoutInflater)
    }
}