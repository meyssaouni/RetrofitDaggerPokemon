package com.example.meyss.javaretrofitdagger.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface PokemonDAO {

    @get:Query("SELECT * FROM Pokemon")
    val all: LiveData<List<Pokemon>>

    @get:Transaction
    @get:Query("SELECT * FROM Pokemon")
    val pokAttack: List<PokAttacks>

    @Insert
    fun insertAll(poks: List<Pokemon>)

    @Insert
    fun insertAllAttacks(attacks: List<Attack>)

    @Query("SELECT * FROM Pokemon WHERE name LIKE :nom")
    fun findByName(nom: String): Pokemon

}
