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

    @Query("SELECT * FROM Pokemon WHERE id LIKE :id")
    fun findByName(id: String): Pokemon

    //Attacks by pok
    @Query("SELECT * FROM Attack WHERE pokId LIKE :idpok")
    fun AttacksPokId(idpok : String): List<Attack>

}
