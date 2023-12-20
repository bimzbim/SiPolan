package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class BantuanResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: BantuanData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class BantuanData(

	@field:SerializedName("messageId")
	val messageId: Int,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("userId")
	val userId: String,

	@field:SerializedName("categoryId")
	val categoryId: Int,

	@field:SerializedName("timestamp")
	val timestamp: String
)

data class BantuanRequest(
	@SerializedName("userId") val userId: Int,
	@SerializedName("categoryId") val categoryId: Int,
	@SerializedName("message") val message: String
)
