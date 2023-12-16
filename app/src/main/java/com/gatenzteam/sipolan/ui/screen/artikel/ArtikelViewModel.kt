package com.gatenzteam.sipolan.ui.screen.artikel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import com.gatenzteam.sipolan.data.repository.ArtikelRepository
import com.gatenzteam.sipolan.data.pref.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ArtikelViewModel(private val repository: ArtikelRepository) : ViewModel() {
    private val _artikelState = MutableStateFlow<ResultState<GetArtikelResponse>>(ResultState.Loading)
    val artikelState: StateFlow<ResultState<GetArtikelResponse>> get() = _artikelState

    init {
        getArtikel()
    }
    fun getArtikel() {
        viewModelScope.launch {
            repository.getArtikel()
                .onStart { _artikelState.value = ResultState.Loading }
                .collect { resultState ->
                    _artikelState.value = resultState
                }
        }
    }
}