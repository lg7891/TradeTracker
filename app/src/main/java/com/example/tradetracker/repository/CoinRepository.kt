package com.example.tradetracker.repository

import ApiCoin
import CoinGeckoApi

class CoinRepository(private val api: CoinGeckoApi) {
    suspend fun getCoins(vsCurrency: String): List<ApiCoin> {
        return api.getCoins(vsCurrency)
    }
}
