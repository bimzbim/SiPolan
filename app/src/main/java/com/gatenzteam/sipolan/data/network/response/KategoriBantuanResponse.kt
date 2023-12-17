package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class KategoriBantuanResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: List<KategoriBantuanData>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class KategoriBantuanData(

	@field:SerializedName("categoryName")
	val categoryName: String,

	@field:SerializedName("categoryId")
	val categoryId: Int
)
