class CoinRepository(private val api: CoinGeckoApi) {
    suspend fun getCoins(vsCurrency: String): List<Coin> {
        return api.getCoins(vsCurrency)
    }
}
