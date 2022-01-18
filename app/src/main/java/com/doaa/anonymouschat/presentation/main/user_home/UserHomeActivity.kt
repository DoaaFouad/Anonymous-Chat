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

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.doaa.anonymouschat.R
import com.doaa.anonymouschat.databinding.ActivityUserHomeBinding
import com.doaa.anonymouschat.domain.entities.messaging.ConversationListItem
import com.doaa.anonymouschat.domain.entities.messaging.Message
import com.doaa.anonymouschat.presentation.base.BaseActivity
import com.doaa.anonymouschat.presentation.main.conversation.ConversationActivity
import com.doaa.anonymouschat.presentation.main.join_chat.JoinChatActivity
import com.doaa.anonymouschat.utils.constants.BundleKeys
import com.doaa.anonymouschat.utils.copyPublicKeyToClipBoard
import com.doaa.anonymouschat.utils.sharePublicKey
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserHomeActivity :
    BaseActivity<UserHomeContract.Intent, UserHomeContract.State, UserHomeContract.Effect, ActivityUserHomeBinding>(), AllConversationsListener {

    override val viewModel by viewModel<UserHomeViewModel>()

    private var allConversationAdapter = AllConversationsAdapter(this) // TODO inject

    override fun observeViewState() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                when (val state = it.userHomeViewState) {
                    is UserHomeContract.UserHomeViewState.Idle -> {

                    }

                    is UserHomeContract.UserHomeViewState.UserInfoSuccess -> {
                        initUserInfo(state.userName, state.publicKey)
                    }

                    is UserHomeContract.UserHomeViewState.NewMessage -> {
                        hideConversationsNullView()
                        addToData(state.conversationItemList)
                    }
                }

            }
        }
    }

    override fun init() {
        super.init()

        initRecyclerviewer()
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

    private fun initRecyclerviewer() {
        binding?.rvConversations?.layoutManager =
            LinearLayoutManager(this)
        binding?.rvConversations?.adapter = allConversationAdapter
    }

    private fun populateData(conversationList: MutableList<ConversationListItem>?) {
        allConversationAdapter.setData(conversationList)
    }

    private fun addToData(item: ConversationListItem) {
        allConversationAdapter.addToData(item)
    }

    private fun hideConversationsNullView(){
        binding?.tvNoConversations?.visibility = View.GONE
    }

    override fun onItemClicked(identifier: String?, lastMessage: String?) {
        val bundle = Bundle()
        bundle.putString(BundleKeys.CONVERSATION_ITEM_IDENTIFIER, identifier)
        bundle.putString(BundleKeys.CONVERSATION_ITEM_LAST_MESSAGE, lastMessage)
        navigateToActivity(ConversationActivity::class.java, bundle)
    }

    override fun getViewBinding(): ActivityUserHomeBinding {
        return ActivityUserHomeBinding.inflate(layoutInflater)
    }

}