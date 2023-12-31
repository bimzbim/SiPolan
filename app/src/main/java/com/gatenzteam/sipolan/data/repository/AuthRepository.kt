package com.gatenzteam.sipolan.data.repository

import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.ErrorResponse
import com.gatenzteam.sipolan.data.network.response.SignInResponse
import com.gatenzteam.sipolan.data.network.response.SignUpResponse
import com.gatenzteam.sipolan.data.network.retrofit.ApiService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class AuthRepository private constructor(
    private val apiService: ApiService
){

    fun signIn(email: String, password: String) : Flow<ResultState<SignInResponse>> = flow {
        try {
            val response = apiService.signIn(email, password)
            if(response.code == "200"){
                emit(ResultState.Success(response))
            } else {
                emit(ResultState.Error(response.message))
            }
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            emit(ResultState.Error(errorBody.errors))
        }
    }

    fun signUp(fullname: String, email: String, vehicleNumber: String, password: String) : Flow<ResultState<SignUpResponse>> = flow {
        try {
            val response = apiService.signUp(fullname, email, vehicleNumber, password)
            if(response.code == "201"){
                emit(ResultState.Success(response))
            } else {
                emit(ResultState.Error(response.message))
            }
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            emit(ResultState.Error(errorBody.errors))
        }
    }

    companion object {
        @Volatile
        private var instance: AuthRepository? = null
        fun getInstance(
            apiService: ApiService
        ): AuthRepository =
            instance ?: synchronized(this) {
                instance ?: AuthRepository(apiService)
            }.also { instance = it }
    }
}