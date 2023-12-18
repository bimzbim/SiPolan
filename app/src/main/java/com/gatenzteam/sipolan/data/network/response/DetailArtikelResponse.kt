package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class DetailArtikelResponse(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("data")
	val data: ArtikelData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class ArtikelData(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("content")
	val content: String,

	@field:SerializedName("tags")
	val tags: List<String>,

	@field:SerializedName("updatedAt")
	val updatedAt: String
)
