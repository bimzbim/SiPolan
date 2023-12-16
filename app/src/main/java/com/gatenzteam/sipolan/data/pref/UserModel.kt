package com.gatenzteam.sipolan.data.pref

data class UserModel(
    val userId: String,
    val userName: String,
    val token: String,
    val isLogin: Boolean = false
)