package com.gatenzteam.sipolan.utils

import androidx.lifecycle.ViewModelProvider
import com.gatenzteam.sipolan.data.repository.PelanggaranSayaRepository

class PusatBantuanViewModelFactory (private val repository: PelanggaranSayaRepository) :
    ViewModelProvider.NewInstanceFactory() {
}