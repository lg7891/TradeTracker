package com.example.tradetracker.viewmodel

import com.example.tradetracker.api.CoinRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CoinViewModelFactory(private val repository: CoinRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinViewModel::class.java)) {
            return CoinViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
