package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class GetPembayaranMethodResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: PembayaranMethodData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class PembayaranMethodData(

	@field:SerializedName("payment_methods")
	val paymentMethods: List<PaymentMethodsItem>
)

data class PaymentMethodsItem(

	@field:SerializedName("provider")
	val provider: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: String
)
