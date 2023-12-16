package com.gatenzteam.sipolan.data.network.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("errors")
    val errors: String? = null,
)