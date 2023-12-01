package com.gatenzteam.sipolan.ui.navigation

sealed class Screen(val route: String){
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Deteksi : Screen("deteksi")

}