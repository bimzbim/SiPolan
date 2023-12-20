package com.gatenzteam.sipolan.data.repository

import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.BantuanRequest
import com.gatenzteam.sipolan.data.network.response.BantuanResponse
import com.gatenzteam.sipolan.data.network.response.ErrorResponse
import com.gatenzteam.sipolan.data.network.response.KategoriBantuanResponse
import com.gatenzteam.sipolan.data.network.retrofit.ApiService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class PusatBantuanRepository private constructor(
    private val apiService: ApiService
) {
    suspend fun getKategoriBantuan() : Flow<ResultState<KategoriBantuanResponse>> {
        return try {
            val response = apiService.kategoriBantuan()
            if(response.data.isNotEmpty()){
                flow { emit(ResultState.Success(response)) }
            } else {
                flow { emit(ResultState.Error("Tidak dapat mendapatkan kategori")) }
            }
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            flow { emit(ResultState.Error(errorBody.errors)) }
        }
    }

    fun sendMessage(userId: Int, categoryId: Int, message: String): Flow<ResultState<BantuanResponse>> = flow {
        try {
            val request = BantuanRequest(userId, categoryId, message)
            val response = apiService.bantuan(request)
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
        private var instance: PusatBantuanRepository? = null

        fun getInstance(apiService: ApiService): PusatBantuanRepository =
            instance ?: synchronized(this) {
                instance ?: PusatBantuanRepository(apiService)
            }.also { instance = it }
    }
}



