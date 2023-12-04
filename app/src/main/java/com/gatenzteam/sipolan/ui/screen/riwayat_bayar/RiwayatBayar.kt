package com.gatenzteam.sipolan.ui.screen.riwayat_bayar

data class RiwayatBayar (
    val id: String,
    val biaya: String,
    val tanggal: String,
    val status: String
)

object DataBayar{
    val dummy = listOf(
        RiwayatBayar("11111", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("22222", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("33333", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("44444", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("55555", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("66666", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("77777", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("88888", "500.000", "29-11-2023", "Belum Terbayar"),
        RiwayatBayar("99999", "500.000", "29-11-2023", "Belum Terbayar")
    )
}