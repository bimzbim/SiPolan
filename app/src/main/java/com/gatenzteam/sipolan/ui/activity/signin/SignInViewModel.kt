package com.gatenzteam.sipolan.ui.activity.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.SignInResponse
import com.gatenzteam.sipolan.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _signInState = MutableStateFlow<ResultState<SignInResponse>>(ResultState.Loading)
    val signInState: StateFlow<ResultState<SignInResponse>> = _signInState.asStateFlow()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            repository.signIn(email, password)
                .collect { result ->
                    _signInState.value = result
                }
        }
    }
}