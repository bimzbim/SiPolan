package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
	@field:SerializedName("data")
	val data: Data
)

data class Data(
	@field:SerializedName("vehicle_number_plate")
	val vehicleNumberPlate: String,

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("fullname")
	val fullname: String,

	@field:SerializedName("email")
	val email: String
)
