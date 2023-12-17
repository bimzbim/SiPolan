package com.gatenzteam.sipolan.ui.screen.pelanggaran_saya

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.GetDeteksiResponse
import com.gatenzteam.sipolan.data.network.response.GetPelanggaranUserResponse
import com.gatenzteam.sipolan.data.repository.DeteksiRepository
import com.gatenzteam.sipolan.data.repository.PelanggaranSayaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PelanggaranSayaViewModel(private val repository: PelanggaranSayaRepository) : ViewModel() {
    private val _pelanggaranUserState = MutableStateFlow<ResultState<GetPelanggaranUserResponse>>(ResultState.Loading)
    val pelanggaranUserState: StateFlow<ResultState<GetPelanggaranUserResponse>> get() = _pelanggaranUserState

    fun getPelanggaranUser(userId: Int, limit: Int) {
        viewModelScope.launch {
            repository.getPelanggaranUser(userId, limit)
                .onStart { _pelanggaranUserState.value = ResultState.Loading }
                .collect { resultState ->
                    _pelanggaranUserState.value = resultState
                }
        }
    }

}