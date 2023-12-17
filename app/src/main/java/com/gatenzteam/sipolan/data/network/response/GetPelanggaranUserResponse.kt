package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class GetPelanggaranUserResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: PelanggaranUserData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class PelanggaranUserData(

	@field:SerializedName("violations")
	val violations: List<ViolationsUserItem>
)

data class ViolationsUserItem(

	@field:SerializedName("vehicle-number-plate")
	val vehicleNumberPlate: String,

	@field:SerializedName("location")
	val location: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("timestamp")
	val timestamp: String
)
