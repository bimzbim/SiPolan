package com.gatenzteam.sipolan.data.repository

import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.ErrorResponse
import com.gatenzteam.sipolan.data.network.response.GetPelanggaranUserResponse
import com.gatenzteam.sipolan.data.network.response.GetPembayaranResponse
import com.gatenzteam.sipolan.data.network.retrofit.ApiService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RiwayatBayarRepository private constructor(
    private val apiService: ApiService
){
    suspend fun getRiwayatBayar(userId: Int, limit: Int = 10) : Flow<ResultState<GetPembayaranResponse>> {
        try {
            val response = apiService.getPembayaran(userId, limit)
            if(response.data.payments.isNotEmpty()){
                return flow { emit(ResultState.Success(response)) }
            } else {
                return flow { emit(ResultState.Error("Bravo! Anda belum memiliki denda yang harus dibayarkan")) }
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
        private var instance: RiwayatBayarRepository? = null
        fun getInstance(
            apiService: ApiService
        ): RiwayatBayarRepository =
            instance ?: synchronized(this) {
                instance ?: RiwayatBayarRepository(apiService)
            }.also { instance = it }
    }
}