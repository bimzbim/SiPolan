package com.gatenzteam.sipolan.ui.screen.deteksi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.DetailPelanggaranResponse
import com.gatenzteam.sipolan.data.network.response.GetDeteksiResponse
import com.gatenzteam.sipolan.data.repository.DeteksiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DeteksiViewModel(private val repository: DeteksiRepository) : ViewModel() {
    private val _deteksiState = MutableStateFlow<ResultState<GetDeteksiResponse>>(ResultState.Loading)
    val deteksiState: StateFlow<ResultState<GetDeteksiResponse>> get() = _deteksiState

    private val _detailPelanggaranState = MutableStateFlow<ResultState<DetailPelanggaranResponse>>(ResultState.Loading)
    val detailPelanggaranState: StateFlow<ResultState<DetailPelanggaranResponse>> get() = _detailPelanggaranState

    fun getDeteksi(limit: Int) {
        viewModelScope.launch {
            repository.getDeteksi(limit)
                .onStart { _deteksiState.value = ResultState.Loading }
                .collect { resultState ->
                    _deteksiState.value = resultState
                }
        }
    }

    fun getPelanggaranDetail(violationId: Int) {
        viewModelScope.launch {
            repository.getPelanggaranDetail(violationId)
                .onStart { _detailPelanggaranState.value = ResultState.Loading }
                .collect { resultState ->
                    _detailPelanggaranState.value = resultState
                }
        }
    }

}