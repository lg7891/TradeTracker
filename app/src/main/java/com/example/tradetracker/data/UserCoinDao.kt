package com.example.tradetracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.tradetracker.models.UserCoin
import kotlinx.coroutines.flow.Flow

@Dao
interface UserCoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserCoin(userCoin: UserCoin)

    @Delete
    fun deleteUserCoin(userCoin: UserCoin)

    @Update
    fun updateUserCoin(userCoin: UserCoin)

    @Query("SELECT * from user_coins WHERE id = :id")
    fun getUserCoin(id: String): Flow<UserCoin>

    @Query("SELECT * FROM user_coins")
    fun getAllUserCoins(): Flow<List<UserCoin>>
}