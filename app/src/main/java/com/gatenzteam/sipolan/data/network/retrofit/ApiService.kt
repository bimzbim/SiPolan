package com.gatenzteam.sipolan.data.network.retrofit

import com.gatenzteam.sipolan.data.network.response.DetailArtikelResponse
import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import com.gatenzteam.sipolan.data.network.response.LoginResponse
import com.gatenzteam.sipolan.data.network.response.SignUpResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
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

    @GET("3360292d-e6e9-460f-bed2-5d4a5df58b09")
    suspend fun getDetailArtikel(
        @Query("articleId") articleId: Int,
    ): DetailArtikelResponse

    @FormUrlEncoded
    @POST("5acfd00a-bf84-48c3-9a5e-8038117298c2")
    suspend fun signup(
        @Field("fullname") fullname: String,
        @Field("email") email: String,
        @Field("vehicle_number_plate") vehicleNumberPlate: String,
        @Field("password") password: String
    ): SignUpResponse

    @FormUrlEncoded
    @POST("0f015c92-4cfc-4d7e-9ada-d9288384d77e")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

}