import retrofit2.http.GET
import retrofit2.http.Query

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val current_price: Double,
    val image: String
)

interface CoinGeckoApi {
    @GET("coins/markets")
    suspend fun getCoins(
        @Query("vs_currency") vsCurrency: String,
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): List<Coin>
}
