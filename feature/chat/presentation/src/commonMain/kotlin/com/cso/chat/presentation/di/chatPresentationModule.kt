package com.cso.chat.presentation.di


import com.cso.chat.presentation.chat_list.ChatListViewModel
import com.cso.chat.presentation.chat_list_detail.ChatListDetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val chatPresentationModule = module {
    viewModelOf(::ChatListViewModel)
    viewModelOf(::ChatListDetailViewModel)
}