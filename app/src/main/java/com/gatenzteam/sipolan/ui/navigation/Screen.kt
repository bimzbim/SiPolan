package com.gatenzteam.sipolan.ui.navigation

sealed class Screen(val route: String){
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Deteksi : Screen("deteksi")
    object EditAkun : Screen("edit akun")
    object RiwayatPembayaran : Screen("riwayat pembayaran")
    object PelanggaranSaya : Screen("pelanggaran saya")
    object PusatBantuan : Screen("pusat bantuan")

}