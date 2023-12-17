package com.gatenzteam.sipolan.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gatenzteam.sipolan.data.repository.PelanggaranSayaRepository
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.screen.deteksi.DeteksiViewModel
import com.gatenzteam.sipolan.ui.screen.pelanggaran_saya.PelanggaranSayaViewModel

class PelanggaranSayaViewModelFactory(private val repository: PelanggaranSayaRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PelanggaranSayaViewModel::class.java) -> {
                PelanggaranSayaViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: PelanggaranSayaViewModelFactory? = null
        fun getInstance(context: Context): PelanggaranSayaViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: PelanggaranSayaViewModelFactory(Injection.providePelanggaranSayaRepository())
            }.also { instance = it }
    }
}