package com.gatenzteam.sipolan.ui.screen.deteksi

import com.gatenzteam.sipolan.R

data class Deteksi (
    val id: String,
    val img: Int,
    val jenis: String,
    val nopol: String,
    val tgl: String
)

object DataDeteksi{
    val dummy = listOf(
        Deteksi("1", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        Deteksi("2", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        Deteksi("3", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        Deteksi("5", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        Deteksi("6", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
    )
}