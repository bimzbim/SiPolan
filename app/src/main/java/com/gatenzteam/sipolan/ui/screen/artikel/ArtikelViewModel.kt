package com.gatenzteam.sipolan.ui.screen.artikel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.DetailArtikelResponse
import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import com.gatenzteam.sipolan.data.repository.ArtikelRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ArtikelViewModel(private val repository: ArtikelRepository) : ViewModel() {
    private val _artikelState = MutableStateFlow<ResultState<GetArtikelResponse>>(ResultState.Loading)
    val artikelState: StateFlow<ResultState<GetArtikelResponse>> get() = _artikelState

    private val _artikelDetailState = MutableStateFlow<ResultState<DetailArtikelResponse>>(ResultState.Loading)

    val artikelDetailState: StateFlow<ResultState<DetailArtikelResponse>> get() = _artikelDetailState

    private val _querySearch = mutableStateOf("")
    val querySearch: State<String> get() = _querySearch

    fun getArtikel(page: Int, limit: Int) {
        viewModelScope.launch {
            repository.getArtikel(page, limit)
                .onStart { _artikelState.value = ResultState.Loading }
                .collect { resultState ->
                    _artikelState.value = resultState
                }
        }
    }

    fun getArtikelDetail(articleId: Int) {
        viewModelScope.launch {
            repository.getArtikelDetail(articleId)
                .onStart { _artikelDetailState.value = ResultState.Loading }
                .collect { resultState ->
                    _artikelDetailState.value = resultState
                }
        }
    }

}