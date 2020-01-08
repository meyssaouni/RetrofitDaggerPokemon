package com.example.meyss.javaretrofitdagger.data;

import androidx.lifecycle.LiveData;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public interface PokemonDAO {

    @Insert
    void insertAll( List<Pokemon>poks);

    @Insert
    void insertAllAttacks( List<Attack>attacks);

    @Query("SELECT * FROM Pokemon")
    List<Pokemon> getAll();

    @Query("SELECT * FROM Pokemon WHERE name LIKE :nom")
   Pokemon findByName(String nom);

    @Transaction
    @Query("SELECT * FROM Pokemon")
    public List<PokAttacks> getPokAttack();

}
