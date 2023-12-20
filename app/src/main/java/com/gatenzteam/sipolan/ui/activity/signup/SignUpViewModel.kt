package com.gatenzteam.sipolan.ui.activity.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.SignUpResponse
import com.gatenzteam.sipolan.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(private val repository: AuthRepository) : ViewModel() {
    private val _signUpState = MutableStateFlow<ResultState<SignUpResponse>>(ResultState.Loading)
    val signUpState: StateFlow<ResultState<SignUpResponse>> = _signUpState.asStateFlow()

    fun signUp(fullname: String, email: String, vehicleNumber: String, password: String) {
        viewModelScope.launch {
            repository.signUp(fullname, email, vehicleNumber, password)
                .collect { result ->
                    _signUpState.value = result
                }
        }
    }
}