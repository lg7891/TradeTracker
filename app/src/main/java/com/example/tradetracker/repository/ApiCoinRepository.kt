package com.example.tradetracker.repository

import CoinGeckoApi
import com.example.tradetracker.models.ApiCoin

class CoinRepository(private val api: CoinGeckoApi) {
    suspend fun getCoins(vsCurrency: String): List<ApiCoin> {
        return api.getCoins(vsCurrency)
    }
}
