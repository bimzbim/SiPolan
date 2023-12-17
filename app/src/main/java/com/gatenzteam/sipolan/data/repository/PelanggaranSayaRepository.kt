package com.gatenzteam.sipolan.data.repository

import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.ErrorResponse
import com.gatenzteam.sipolan.data.network.response.GetDeteksiResponse
import com.gatenzteam.sipolan.data.network.response.GetPelanggaranUserResponse
import com.gatenzteam.sipolan.data.network.retrofit.ApiService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class PelanggaranSayaRepository private constructor(
    private val apiService: ApiService
){
    suspend fun getPelanggaranUser(userId: Int, limit: Int = 10) : Flow<ResultState<GetPelanggaranUserResponse>> {
        try {
            val response = apiService.getPelanggaranUser(userId, limit)
            if(response.data.violations.isNotEmpty()){
                return flow { emit(ResultState.Success(response)) }
            } else {
                return flow { emit(ResultState.Error("Syukurlah anda belum pernah melanggar, tetaplah mematuhi peraturan lalu lintas untuk keselamatan")) }
            }
        } catch (e: HttpException) {
            //Mendapatkan Pesan Error
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            return flow { emit(ResultState.Error(errorBody.errors)) }
        }
    }
    companion object {
        @Volatile
        private var instance: PelanggaranSayaRepository? = null
        fun getInstance(
            apiService: ApiService
        ): PelanggaranSayaRepository =
            instance ?: synchronized(this) {
                instance ?: PelanggaranSayaRepository(apiService)
            }.also { instance = it }
    }
}