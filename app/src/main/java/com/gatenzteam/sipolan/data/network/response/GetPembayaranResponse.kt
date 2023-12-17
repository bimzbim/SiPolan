package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class GetPembayaranResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: PembayaranData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class PaymentsItem(

	@field:SerializedName("id-pembayaran")
	val idPembayaran: String,

	@field:SerializedName("biaya")
	val biaya: String,

	@field:SerializedName("timestamp")
	val timestamp: String,

	@field:SerializedName("status")
	val status: String
)

data class PembayaranData(

	@field:SerializedName("payments")
	val payments: List<PaymentsItem>
)
