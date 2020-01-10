package com.example.meyss.javaretrofitdagger.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class, Attack::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDAO
}
