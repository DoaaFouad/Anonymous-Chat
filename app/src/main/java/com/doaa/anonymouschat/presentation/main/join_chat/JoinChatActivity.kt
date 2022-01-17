/*
 * *
 * Created by Doaa Fouad on 1/14/22 2:54 AM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/14/22 2:54 AM
 *
 */

package com.doaa.anonymouschat.presentation.main.join_chat

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.doaa.anonymouschat.R
import com.doaa.anonymouschat.databinding.ActivityJoinChatBinding
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.presentation.main.conversation.ConversationActivity
import com.doaa.anonymouschat.utils.constants.BundleKeys
import com.doaa.anonymouschat.utils.crypto.Validation
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class JoinChatActivity :
    BaseActivity<JoinChatContract.Intent, JoinChatContract.State, JoinChatContract.Effect, ActivityJoinChatBinding>() {

    override val viewModel by viewModel<JoinChatViewModel>()

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.joinChatViewState) {
                    is JoinChatContract.JoinChatViewState.Idle -> {

                    }
                }

            }
        }
    }

    override fun setListeners() {
        super.setListeners()

        binding?.btnJoin?.setOnClickListener {
            navigateToConversationActivity()
        }
    }

    private fun navigateToConversationActivity() {
        val enteredPublicKey = binding?.etChatPublicKey?.text.toString()
        if (Validation.isPublicKeyValid(enteredPublicKey, false)) {
            val bundle = Bundle()
            bundle.putString(BundleKeys.CONVERSATION_PUBLIC_KEY, enteredPublicKey)
            navigateToActivity(ConversationActivity::class.java, bundle)
        } else {
            showLongToast(getString(R.string.error_invalid))
        }
    }

    override fun getViewBinding(): ActivityJoinChatBinding {
        return ActivityJoinChatBinding.inflate(layoutInflater)
    }
}