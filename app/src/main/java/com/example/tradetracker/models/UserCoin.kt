package com.example.tradetracker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_coins")
data class UserCoin(
    @PrimaryKey
    val id: String,
    val name: String,
    val amount: Double
)