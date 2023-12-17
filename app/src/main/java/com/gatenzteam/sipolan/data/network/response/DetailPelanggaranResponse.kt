package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class DetailPelanggaranResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: DetailPelanggaranData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DetailPelanggaranData(

	@field:SerializedName("vehicle-number-plate")
	val vehicleNumberPlate: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("user")
	val user: UserPelanggaran,

	@field:SerializedName("timestamp")
	val timestamp: String
)

data class UserPelanggaran(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("fullname")
	val fullname: String
)
