package com.gatenzteam.sipolan.data.network.retrofit

import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import com.gatenzteam.sipolan.data.network.response.SignUpResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("f662b3ef-9212-42cb-82d6-027e18c812f5")
    suspend fun getArtikel(
        @Query("category") category: String = "",
        @Query("tags") tags: String = "",
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): GetArtikelResponse

    @POST("5acfd00a-bf84-48c3-9a5e-8038117298c2")
    suspend fun signUp(
        @Body("fullname") fullname: String,
        @Body("email") email: String,
        @Body("vehicle_number_plate") vehicleNumberPlate: String,
        @Body("password") password: String
    ): SignUpResponse



}