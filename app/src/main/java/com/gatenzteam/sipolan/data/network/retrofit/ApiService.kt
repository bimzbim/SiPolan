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

    @GET("038baf37-aa47-4148-82fa-b4efae667440")
    suspend fun getDeteksi(
        @Query("limit") limit: Int
    ): GetDeteksiResponse

    @GET("07a9595e-f7e5-4610-a7b8-67fd6fcf5867")
    suspend fun getPelanggaranUser(
        @Query("userId") userId: Int,
        @Query("limit") limit: Int
    ): GetPelanggaranUserResponse

    @GET("fbe8d81e-abb6-4edc-b1d9-0372a83afaa9")
    suspend fun getPelanggaranDetail(
        @Query("violationId") violationId: Int
    ): DetailPelanggaranResponse

    @GET("97140261-fb36-44f7-8031-d1eb48e69e07")
    suspend fun getPembayaranMethod(
        @Query("userId") userId: Int,
    ): GetPembayaranMethodResponse

    @GET("3845821b-0975-4729-a6ec-79bdcca36305")
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