package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: SignInData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class SignInData(

	@field:SerializedName("user")
	val user: User,

	@field:SerializedName("token")
	val token: String
)

data class User(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("fullname")
	val fullname: String,

	@field:SerializedName("email")
	val email: String
)
