import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CoinViewModel(private val repository: CoinRepository) : ViewModel() {
    private val _coins = MutableStateFlow<List<Coin>>(emptyList())
    val coins: StateFlow<List<Coin>> get() = _coins

    fun fetchCoins(vsCurrency: String) {
        viewModelScope.launch {
            try {
                val fetchedCoins = repository.getCoins(vsCurrency)
                _coins.value = fetchedCoins
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
