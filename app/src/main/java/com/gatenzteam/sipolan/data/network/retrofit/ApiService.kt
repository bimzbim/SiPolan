package com.gatenzteam.sipolan.data.network.retrofit

import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("stories")
    suspend fun getStories(
        @Query("category") category: String = "",
        @Query("tags") tags: String = "",
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10
    ): GetArtikelResponse
}