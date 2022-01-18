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
import androidx.recyclerview.widget.LinearLayoutManager
import com.doaa.anonymouschat.R
import com.doaa.anonymouschat.databinding.ActivityConversationBinding
import com.doaa.anonymouschat.domain.entities.messaging.Message
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.utils.constants.BundleKeys
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConversationActivity :
    BaseActivity<ConversationContract.Intent, ConversationContract.State, ConversationContract.Effect, ActivityConversationBinding>() {

    override val viewModel by viewModel<ConversationViewModel>()

    private val conversationAdapter by inject<ConversationAdapter>()

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.conversationViewState) {
                    is ConversationContract.ConversationViewState.Idle -> {

                    }

                    is ConversationContract.ConversationViewState.NewMessage -> {
                        addToData(state.message)
                    }
                }
            }
        }
    }

    override fun setListeners() {
        super.setListeners()

        binding?.btnSend?.setOnClickListener {
            viewModel.setIntent(ConversationContract.Intent.SendMessage(binding?.etMessage?.text.toString()))
            resetMessageBox()
        }
    }

    override fun init() {
        super.init()

        initRecyclerviewer()

        val convPublicKey = intent.extras?.getString(BundleKeys.CONVERSATION_PUBLIC_KEY)
        convPublicKey?.let {
            viewModel.setIntent(ConversationContract.Intent.InitConversation(convPublicKey))
            binding?.tvRecipientPublicKey?.text = it
        }?: kotlin.run {
            initPassedLastMessage()
          //  showLongToast(getString(R.string.error))
        }
    }

    private fun initRecyclerviewer() {
        binding?.rvConversation?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        binding?.rvConversation?.adapter = conversationAdapter
    }

    private fun populateData(messagesData: MutableList<Message>?) {
        conversationAdapter.setData(messagesData)
    }

    private fun addToData(message: Message) {
        conversationAdapter.addToData(message)
    }

    private fun resetMessageBox(){
        binding?.etMessage?.text?.clear()
        hideKeyboard()

    }

    private fun initPassedLastMessage(){
        val identifier = intent.extras?.getString(BundleKeys.CONVERSATION_ITEM_IDENTIFIER)
        val lastMessage = intent.extras?.getString(BundleKeys.CONVERSATION_ITEM_LAST_MESSAGE)

        identifier?.let {
            binding?.tvRecipientPublicKey?.text = identifier
            viewModel.setIntent(ConversationContract.Intent.InitConversation(identifier))
        }
        lastMessage?.let {
            addToData(Message(decryptedMessage = lastMessage))
        }
    }

    override fun getViewBinding(): ActivityConversationBinding {
        return ActivityConversationBinding.inflate(layoutInflater)
    }
}