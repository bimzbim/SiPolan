package com.gatenzteam.sipolan.ui.screen.deteksi

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import com.gatenzteam.sipolan.data.network.response.GetDeteksiResponse
import com.gatenzteam.sipolan.data.repository.ArtikelRepository
import com.gatenzteam.sipolan.data.repository.DeteksiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DeteksiViewModel(private val repository: DeteksiRepository) : ViewModel() {
    private val _deteksiState = MutableStateFlow<ResultState<GetDeteksiResponse>>(ResultState.Loading)
    val deteksiState: StateFlow<ResultState<GetDeteksiResponse>> get() = _deteksiState

    fun getDeteksi(limit: Int) {
        viewModelScope.launch {
            repository.getDeteksi(limit)
                .onStart { _deteksiState.value = ResultState.Loading }
                .collect { resultState ->
                    _deteksiState.value = resultState
                }
        }
    }

}