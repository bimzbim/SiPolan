package com.gatenzteam.sipolan.data.repository

import com.gatenzteam.sipolan.data.ResultState
import com.gatenzteam.sipolan.data.network.response.DetailArtikelResponse
import com.gatenzteam.sipolan.data.network.response.ErrorResponse
import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import com.gatenzteam.sipolan.data.network.retrofit.ApiService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ArtikelRepository private constructor(
    private val apiService: ApiService
){
    suspend fun getArtikel(page: Int = 1, limit: Int = 10) : Flow<ResultState<GetArtikelResponse>> {
        try {
            val response = apiService.getArtikel(page = page, limit = limit)
            if(response.articles.isNotEmpty()){
                return flow { emit(ResultState.Success(response)) }
            } else {
                return flow { emit(ResultState.Error("Masih belum tersedia artikel untuk anda")) }
            }
        } catch (e: HttpException) {
            //Mendapatkan Pesan Error
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            return flow { emit(ResultState.Error(errorBody.errors)) }
        }
    }

    suspend fun getArtikelDetail(articleId: Int) : Flow<ResultState<DetailArtikelResponse>> {
        try {
            val response = apiService.getDetailArtikel(articleId)
            if(response.data.id != 0){
                return flow { emit(ResultState.Success(response)) }
            } else {
                return flow { emit(ResultState.Error("Artikel tidak ditemukan")) }
            }
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, ErrorResponse::class.java)
            return flow { emit(ResultState.Error(errorBody.errors)) }
        }
    }
    companion object {
        @Volatile
        private var instance: ArtikelRepository? = null
        fun getInstance(
            apiService: ApiService
        ): ArtikelRepository =
            instance ?: synchronized(this) {
                instance ?: ArtikelRepository(apiService)
            }.also { instance = it }
    }
}