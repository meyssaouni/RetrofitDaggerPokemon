package com.example.meyss.javaretrofitdagger.di;

import android.app.Application;
import android.content.Context;

import com.example.meyss.javaretrofitdagger.data.AppDatabase;
import com.example.meyss.javaretrofitdagger.data.PokemonDAO;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class DaoProvider {

    @Provides
    @Singleton
    public PokemonDAO getProvidePokemonDOA(AppDatabase data){
        return data.pokemonDao();
    }

    @Provides
    @Singleton
    public AppDatabase getProvideAppDATAbASE(Application application){
      return    Room.databaseBuilder(application,
                AppDatabase.class, "Cards").allowMainThreadQueries().build();
    }

}
