package com.gatenzteam.sipolan.ui.screen.pusat_bantuan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.KategoriBantuanResponse
import com.gatenzteam.sipolan.data.repository.PusatBantuanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PusatBantuanViewModel(private val repository: PusatBantuanRepository) : ViewModel() {

    private val _kategoriBantuanState = MutableStateFlow<ResultState<KategoriBantuanResponse>>(ResultState.Loading)

    val kategoriBantuanState: StateFlow<ResultState<KategoriBantuanResponse>> get() = _kategoriBantuanState

    fun getKategoriBantuan() {
        viewModelScope.launch {
            repository.getKategoriBantuan()
                .onStart { _kategoriBantuanState.value = ResultState.Loading }
                .collect { resultState ->
                    _kategoriBantuanState.value = resultState
                }
        }
    }
}
