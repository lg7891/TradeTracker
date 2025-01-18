package com.example.tradetracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tradetracker.models.UserCoin

@Database(entities = [UserCoin::class], version = 1, exportSchema = false)
abstract class PortfolioDatabase : RoomDatabase() {
    abstract fun userCoinDao(): UserCoinDao

    companion object {
        @Volatile
        private var INSTANCE: PortfolioDatabase? = null

        fun getDatabase(context: Context): PortfolioDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PortfolioDatabase::class.java,
                    "portfolio_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}