package com.gatenzteam.sipolan.di

import com.gatenzteam.sipolan.data.repository.ArtikelRepository
import com.gatenzteam.sipolan.data.network.retrofit.ApiConfig
import com.gatenzteam.sipolan.data.repository.DeteksiRepository
import com.gatenzteam.sipolan.data.repository.PelanggaranSayaRepository

object Injection {
    fun provideArtikelRepository(): ArtikelRepository {

        val apiService = ApiConfig.getApiService()
        return ArtikelRepository.getInstance(apiService)
    }

    fun provideDeteksiRepository(): DeteksiRepository {

        val apiService = ApiConfig.getApiService()
        return DeteksiRepository.getInstance(apiService)
    }

    fun providePelanggaranSayaRepository(): PelanggaranSayaRepository {

        val apiService = ApiConfig.getApiService()
        return PelanggaranSayaRepository.getInstance(apiService)
    }
}