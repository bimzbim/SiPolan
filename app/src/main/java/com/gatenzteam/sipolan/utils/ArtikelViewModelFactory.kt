package com.gatenzteam.sipolan.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gatenzteam.sipolan.data.repository.ArtikelRepository
import com.gatenzteam.sipolan.di.Injection
import com.gatenzteam.sipolan.ui.screen.artikel.ArtikelViewModel

class ArtikelViewModelFactory(private val repository: ArtikelRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ArtikelViewModel::class.java) -> {
                ArtikelViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ArtikelViewModelFactory? = null
        fun getInstance(context: Context): ArtikelViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ArtikelViewModelFactory(Injection.provideArtikelRepository())
            }.also { instance = it }
    }
}