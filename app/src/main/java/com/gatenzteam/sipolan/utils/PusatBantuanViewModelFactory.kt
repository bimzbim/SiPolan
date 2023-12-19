package com.gatenzteam.sipolan.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gatenzteam.sipolan.data.repository.PusatBantuanRepository
import com.gatenzteam.sipolan.ui.screen.pusat_bantuan.PusatBantuanViewModel

class PusatBantuanViewModelFactory(private val repository: PusatBantuanRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PusatBantuanViewModel::class.java) -> {
                PusatBantuanViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
