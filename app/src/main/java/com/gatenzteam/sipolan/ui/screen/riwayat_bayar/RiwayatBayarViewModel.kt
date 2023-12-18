package com.gatenzteam.sipolan.ui.screen.riwayat_bayar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.GetPelanggaranUserResponse
import com.gatenzteam.sipolan.data.network.response.GetPembayaranResponse
import com.gatenzteam.sipolan.data.repository.RiwayatBayarRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class RiwayatBayarViewModel(private val repository: RiwayatBayarRepository) : ViewModel() {
    private val _riwayatBayarState = MutableStateFlow<ResultState<GetPembayaranResponse>>(ResultState.Loading)
    val riwayatBayarState: StateFlow<ResultState<GetPembayaranResponse>> get() = _riwayatBayarState

    fun getRiwayatBayar(userId: Int, limit: Int) {
        viewModelScope.launch {
            repository.getRiwayatBayar(userId, limit)
                .onStart { _riwayatBayarState.value = ResultState.Loading }
                .collect { resultState ->
                    _riwayatBayarState.value = resultState
                }
        }
    }

}