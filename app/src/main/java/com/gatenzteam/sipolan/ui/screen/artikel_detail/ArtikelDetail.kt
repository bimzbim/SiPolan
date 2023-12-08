package com.gatenzteam.sipolan.ui.screen.artikel_detail

import com.gatenzteam.sipolan.R
data class ArtikelDetail (
    val id: String,
    val img: Int,
    val judul: String,
    val isi: String,
    val tanggal: String
)

object DataDetailArtikel{
    val dummy = ArtikelDetail("1", R.drawable.foto_artikel, "Helm itu gak penting! Yakin Dek?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "08 Desember 2023")
}