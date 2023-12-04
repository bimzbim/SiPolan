package com.gatenzteam.sipolan.ui.screen.pelanggaran_saya

import com.gatenzteam.sipolan.R

data class PelanggaranSaya (
    val id: String,
    val img: Int,
    val jenis: String,
    val nopol: String,
    val tgl: String
)

object DataPelanggaran{
    val dummy = listOf(
        PelanggaranSaya("1", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        PelanggaranSaya("2", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        PelanggaranSaya("3", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        PelanggaranSaya("5", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
        PelanggaranSaya("6", R.drawable.foto_pelanggaran, "Tidak Memakai Helm", "DK 2938 ACL", "28-11-2023 18:09:23"),
    )
}