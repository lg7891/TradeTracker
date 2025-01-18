package com.example.tradetracker.viewmodel

import ApiCoin
import com.example.tradetracker.repository.CoinRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoinViewModel(private val repository: CoinRepository) : ViewModel() {
    private val _coins = MutableStateFlow<List<ApiCoin>>(emptyList())
    val coins: StateFlow<List<ApiCoin>> get() = _coins

    private val _Api_coinDetails = MutableStateFlow<ApiCoin?>(null)
    val apiCoinDetails: StateFlow<ApiCoin?> get() = _Api_coinDetails

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    fun fetchCoins(vsCurrency: String) {
        viewModelScope.launch {
            try {
                val fetchedCoins = repository.getCoins(vsCurrency)
                _coins.value = fetchedCoins
                _errorMessage.value = null
            } catch (e: Exception) {
                e.printStackTrace()
                _errorMessage.value = "Error fetching coin list"
            }
        }
    }

    fun fetchCoinDetails(coinId: String) {
        viewModelScope.launch {
            try {
                val coin = _coins.value.find { it.id == coinId }
                if (coin != null) {
                    _Api_coinDetails.value = coin
                    _errorMessage.value = null
                } else {
                    _errorMessage.value = "Coin not found"
                    _Api_coinDetails.value = null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _errorMessage.value = "Error fetching coin details"
                _Api_coinDetails.value = null
            }
        }
    }
}
