package com.gatenzteam.sipolan.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gatenzteam.sipolan.data.repository.PelanggaranSayaRepository
import com.gatenzteam.sipolan.data.repository.RiwayatBayarRepository
import com.gatenzteam.sipolan.ui.screen.pelanggaran_saya.PelanggaranSayaViewModel
import com.gatenzteam.sipolan.ui.screen.riwayat_bayar.RiwayatBayarViewModel

class RiwayatBayarViewModelFactory(private val repository: RiwayatBayarRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RiwayatBayarViewModel::class.java) -> {
                RiwayatBayarViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

}