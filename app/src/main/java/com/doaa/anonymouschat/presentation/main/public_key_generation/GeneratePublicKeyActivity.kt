/*
 * *
 * Created by Doaa Fouad on 1/13/22 10:26 PM
 * doaa_fouad2006@hotmail.com
 * github.com/DoaaFouad
 * linkedin.com/in/doaafouad/
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 1/13/22 10:26 PM
 *
 */

package com.doaa.anonymouschat.presentation.main.public_key_generation

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import com.doaa.anonymouschat.R
import com.doaa.anonymouschat.databinding.ActivityGeneratePublicKeyBinding
import com.doaa.anonymouschat.domain.entities.crypto.KeyPairResult
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.presentation.main.conversation.ConversationActivity
import com.doaa.anonymouschat.utils.copyPublicKeyToClipBoard
import com.doaa.anonymouschat.utils.sharePublicKey
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class GeneratePublicKeyActivity :
    BaseActivity<GeneratePublicKeyContract.Intent, GeneratePublicKeyContract.State, GeneratePublicKeyContract.Effect, ActivityGeneratePublicKeyBinding>() {

    override val viewModel by viewModel<GeneratePublicKeyViewModel>()

    override fun init() {
        super.init()

        viewModel.setIntent(GeneratePublicKeyContract.Intent.GeneratePublicKey)
    }

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.generatePublicKeyViewState) {
                    is GeneratePublicKeyContract.GeneratePublicKeyViewState.Idle -> {

                    }

                    is GeneratePublicKeyContract.GeneratePublicKeyViewState.Loading -> {

                    }

                    is GeneratePublicKeyContract.GeneratePublicKeyViewState.GeneratePublicKeySuccess -> {
                        updatePublicKeyView(state.keyPairResult)
                    }
                }

            }
        }
    }

    private fun updatePublicKeyView(keyPairResult: KeyPairResult?) {
        keyPairResult?.let { _keyPairResult ->
            binding?.tvPublicKey?.setText(_keyPairResult.ed25519KeyPair.publicKey?.asHexString)
        }
    }

    override fun setListeners() {
        super.setListeners()

        binding?.btnContinue?.setOnClickListener {
            navigateToActivity(ConversationActivity::class.java, null)
        }

        binding?.ivCopy?.setOnClickListener {
            copyPublicKeyToClipBoard("Public Key", binding?.tvPublicKey?.text.toString())
            showLongToast(getString(R.string.public_key_generation_copy_success))
        }

        binding?.ivShare?.setOnClickListener {
            sharePublicKey(binding?.tvPublicKey?.text.toString())
        }
    }

    override fun getViewBinding(): ActivityGeneratePublicKeyBinding {
        return ActivityGeneratePublicKeyBinding.inflate(layoutInflater)
    }
}