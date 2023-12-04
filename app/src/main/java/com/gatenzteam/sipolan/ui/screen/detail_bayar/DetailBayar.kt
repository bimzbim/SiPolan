package com.gatenzteam.sipolan.ui.screen.detail_bayar

data class RiwayatBayar (
    val id: String,
    val jenis: String,
    val biaya: String,
    val tanggal: String,
    val metode: String,
    val status: Boolean
)

object DataDetailBayar{
    val dummy = RiwayatBayar("11111", "Tidak Memakai Helm", "500.000", "04-12-2023", "ShopeePay", true)
}