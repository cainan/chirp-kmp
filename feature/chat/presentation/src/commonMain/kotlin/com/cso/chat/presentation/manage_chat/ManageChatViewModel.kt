package com.cso.chat.presentation.manage_chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cso.chat.presentation.components.manage_chat.ManageChatAction
import com.cso.chat.presentation.components.manage_chat.ManageChatState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

class ManageChatViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val eventChannel = Channel<ManageChatEvent>()
    val events = eventChannel.receiveAsFlow()

    private val _state = MutableStateFlow(ManageChatState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = ManageChatState()
        )

    fun onAction(action: ManageChatAction) {
        when (action) {
            ManageChatAction.OnAddClick -> {}
            ManageChatAction.OnPrimaryActionClick -> {}
            ManageChatAction.OnDismissDialog -> {}
        }
    }

}