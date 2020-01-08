package com.example.meyss.javaretrofitdagger.Repository;

import androidx.lifecycle.LiveData;
import android.content.Context;

import com.example.meyss.javaretrofitdagger.data.AppDatabase;
import com.example.meyss.javaretrofitdagger.data.Attack;
import com.example.meyss.javaretrofitdagger.data.PokAttacks;
import com.example.meyss.javaretrofitdagger.data.Pokemon;
import com.example.meyss.javaretrofitdagger.data.PokemonDAO;

import java.util.List;

import javax.inject.Inject;

import androidx.room.Room;

public class PokemonRepo {
    
    PokemonDAO dao;
    
    @Inject
    public PokemonRepo(PokemonDAO dao) {

         this.dao = dao;

    }

    public void insertAttack( List<Attack> attacks){
        dao.insertAllAttacks(attacks);


        System.out.println("pokemon Repo InsertAttacks");
    }
    public void insertPok( List<Pokemon> poks){
            dao.insertAll(poks);


        System.out.println("pokemon Repo Insert");
    }

    public Pokemon getPokemon(String name) {
        System.out.println("pokemon Repo getByName");
        return dao.findByName(name);


    }
    public List<Pokemon> getAllPoks() {
        System.out.println("pokemon Repo Get all");
        return dao.getAll();
    }

    public List<PokAttacks> getAttacks()
    {
        return dao.getPokAttack();
    }
}
