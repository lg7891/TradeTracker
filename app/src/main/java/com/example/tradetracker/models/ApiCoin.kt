package com.example.tradetracker.models

data class ApiCoin(
    val id: String,
    val symbol: String,
    val name: String,
    val current_price: Double,
    val image: String
)