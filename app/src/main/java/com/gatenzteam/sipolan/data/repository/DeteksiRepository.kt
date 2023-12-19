package com.gatenzteam.sipolan.data.repository

import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.DetailPelanggaranResponse
import com.gatenzteam.sipolan.data.network.response.ErrorResponse
import com.gatenzteam.sipolan.data.network.response.GetDeteksiResponse
import com.gatenzteam.sipolan.data.network.retrofit.ApiService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class DeteksiRepository private constructor(
    private val apiService: ApiService
){
    suspend fun getDeteksi(limit: Int = 10) : Flow<ResultState<GetDeteksiResponse>> {
        try {
            val response = apiService.getDeteksi(limit = limit)
            if(response.data.violations.isNotEmpty()){
                return flow { emit(ResultState.Success(response)) }
            } else {
                return flow { emit(ResultState.Error("Syukurlah tidak ada pelanggaran yang terjadi")) }
            }
        } catch (e: HttpException) {
            //Mendapatkan Pesan Error
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            return flow { emit(ResultState.Error(errorBody.errors)) }
        }
    }

    suspend fun getPelanggaranDetail(violationId: Int): Flow<ResultState<DetailPelanggaranResponse>> {
        try {
            val response = apiService.getPelanggaranDetail(violationId)
            if(response.data.id != 0){
                return flow { emit(ResultState.Success(response)) }
            } else {
                return flow { emit(ResultState.Error("Pelanggaran tidak ditemukan")) }
            }
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            return flow { emit(ResultState.Error(errorBody.errors)) }
        }
    }

    companion object {
        @Volatile
        private var instance: DeteksiRepository? = null
        fun getInstance(
            apiService: ApiService
        ): DeteksiRepository =
            instance ?: synchronized(this) {
                instance ?: DeteksiRepository(apiService)
            }.also { instance = it }
    }
}