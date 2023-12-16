package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class GetArtikelResponse(

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("limit")
	val limit: Int,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem>
)

data class ArticlesItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("published_at")
	val publishedAt: String,

	@field:SerializedName("content")
	val content: String,

	@field:SerializedName("tags")
	val tags: List<String>
)
