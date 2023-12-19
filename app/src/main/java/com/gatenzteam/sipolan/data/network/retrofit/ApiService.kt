package com.gatenzteam.sipolan.data.network.retrofit

import com.gatenzteam.sipolan.data.network.response.BantuanResponse
import com.gatenzteam.sipolan.data.network.response.DetailArtikelResponse
import com.gatenzteam.sipolan.data.network.response.DetailPelanggaranResponse
import com.gatenzteam.sipolan.data.network.response.GetArtikelResponse
import com.gatenzteam.sipolan.data.network.response.GetDeteksiResponse
import com.gatenzteam.sipolan.data.network.response.GetPelanggaranUserResponse
import com.gatenzteam.sipolan.data.network.response.GetPembayaranMethodResponse
import com.gatenzteam.sipolan.data.network.response.GetPembayaranResponse
import com.gatenzteam.sipolan.data.network.response.KategoriBantuanResponse
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

    @GET("c85f4d2a-cdda-4f37-88d5-77aacc286440")
    suspend fun getDetailArtikel(
        @Query("articleId") articleId: Int,
    ): DetailArtikelResponse

    @FormUrlEncoded
    @POST("5acfd00a-bf84-48c3-9a5e-8038117298c2")
    suspend fun signUp(
        @Field("fullname") fullname: String,
        @Field("email") email: String,
        @Field("vehicle_number_plate") vehicleNumberPlate: String,
        @Field("password") password: String
    ): SignUpResponse

    @FormUrlEncoded
    @POST("0f015c92-4cfc-4d7e-9ada-d9288384d77e")
    suspend fun signIn(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("038baf37-aa47-4148-82fa-b4efae667440")
    suspend fun getDeteksi(
        @Query("limit") limit: Int
    ): GetDeteksiResponse

    @GET("538022ac-988e-419e-b69f-e34fc9f3d207")
    suspend fun getPelanggaranUser(
        @Query("userId") userId: Int,
        @Query("limit") limit: Int
    ): GetPelanggaranUserResponse

    @GET("6a8ec01d-1436-4288-93dd-59f20d375784")
    suspend fun getPelanggaranDetail(
        @Query("violationId") violationId: Int
    ): DetailPelanggaranResponse

    @GET("97140261-fb36-44f7-8031-d1eb48e69e07")
    suspend fun getPembayaranMethod(
        @Query("userId") userId: Int,
    ): GetPembayaranMethodResponse

    @GET("31db2d72-03c1-4a77-8ec8-b536827dfa32")
    suspend fun getPembayaran(
        @Query("userId") userId: Int,
        @Query("limit") limit: Int
    ): GetPembayaranResponse

    @POST("0f015c92-4cfc-4d7e-9ada-d9288384d77e")
    suspend fun bantuan(
        @Field("userId") userId: Int,
        @Field("categoryId") categoryId: Int,
        @Field("message") message: String
    ): BantuanResponse

    @GET("6cf55ed8-17c1-4f49-b80b-edfed899f892")
    suspend fun kategoriBantuan(
    ): KategoriBantuanResponse

}