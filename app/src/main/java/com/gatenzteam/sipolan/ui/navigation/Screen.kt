package com.gatenzteam.sipolan.ui.navigation

    sealed class Screen(val route: String){
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Deteksi : Screen("deteksi")
    object EditAkun : Screen("edit akun")
    object RiwayatPembayaran : Screen("riwayat pembayaran")
    object PelanggaranSaya : Screen("pelanggaran saya")
    object PusatBantuan : Screen("pusat bantuan")
    object GantiPassword : Screen("ganti password")
    object DetailPembayaran : Screen("detail pembayaran")
    object MetodePembayaran : Screen("metode pembayaran")
    object Artikel : Screen("artikel")
    object ArtikelDetail : Screen("detail artikel")
    object TataCaraBayar : Screen("tata cara pembayaran")
    object DetailPelanggaran : Screen("detail pelanggaran")
    object KonfirmasiPembayaran : Screen("konfirmasi pembayaran")
}