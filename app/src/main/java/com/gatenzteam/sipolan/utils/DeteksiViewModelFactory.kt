package com.gatenzteam.sipolan.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gatenzteam.sipolan.data.repository.DeteksiRepository
import com.gatenzteam.sipolan.ui.screen.deteksi.DeteksiViewModel

class DeteksiViewModelFactory(private val repository: DeteksiRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DeteksiViewModel::class.java) -> {
                DeteksiViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

}