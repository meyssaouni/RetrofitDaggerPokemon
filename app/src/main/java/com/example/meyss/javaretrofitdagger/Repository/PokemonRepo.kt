package com.example.meyss.javaretrofitdagger.Repository

import androidx.lifecycle.LiveData
import android.content.Context

import com.example.meyss.javaretrofitdagger.data.AppDatabase
import com.example.meyss.javaretrofitdagger.data.Attack
import com.example.meyss.javaretrofitdagger.data.PokAttacks
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.data.PokemonDAO

import javax.inject.Inject

import androidx.room.Room

class PokemonRepo @Inject
constructor(internal var dao: PokemonDAO) {
    val allPoks: List<Pokemon>
        get() {
            println("pokemon Repo Get all")
            return dao.all
        }

    val attacks: List<PokAttacks>
        get() = dao.pokAttack

    fun insertAttack(attacks: List<Attack>) {
        dao.insertAllAttacks(attacks)


        println("pokemon Repo InsertAttacks")
    }

    fun insertPok(poks: List<Pokemon>) {
        dao.insertAll(poks)


        println("pokemon Repo Insert")
    }

    fun getPokemon(name: String): Pokemon {
        println("pokemon Repo getByName")
        return dao.findByName(name)


    }
}
