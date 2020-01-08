package com.example.meyss.javaretrofitdagger.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pokemon.class,Attack.class,},version =2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    public abstract PokemonDAO pokemonDao();
}
