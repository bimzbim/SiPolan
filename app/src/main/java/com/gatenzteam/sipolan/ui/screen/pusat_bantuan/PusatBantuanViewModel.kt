package com.gatenzteam.sipolan.ui.screen.pusat_bantuan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.BantuanResponse
import com.gatenzteam.sipolan.data.network.response.KategoriBantuanResponse
import com.gatenzteam.sipolan.data.repository.PusatBantuanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PusatBantuanViewModel(private val repository: PusatBantuanRepository) : ViewModel() {

    private val _kategoriBantuanState = MutableStateFlow<ResultState<KategoriBantuanResponse>>(ResultState.Loading)
    val kategoriBantuanState: StateFlow<ResultState<KategoriBantuanResponse>> get() = _kategoriBantuanState

    private val _messageState = MutableStateFlow<ResultState<BantuanResponse>>(ResultState.Loading)
    val messageState: StateFlow<ResultState<BantuanResponse>> = _messageState.asStateFlow()

    fun getKategoriBantuan() {
        viewModelScope.launch {
            repository.getKategoriBantuan()
                .onStart { _kategoriBantuanState.value = ResultState.Loading }
                .collect { resultState ->
                    _kategoriBantuanState.value = resultState
                }
        }
    }
    fun sendMessage(userId: Int, categoryId: Int, message: String) {
        viewModelScope.launch {
            repository.sendMessage(1, categoryId, message)
                .collect { result ->
                    _messageState.value = result
                }
        }
    }
}

