package com.example.meyss.javaretrofitdagger.di

import android.app.Application
import android.content.Context

import com.example.meyss.javaretrofitdagger.data.AppDatabase
import com.example.meyss.javaretrofitdagger.data.PokemonDAO

import javax.inject.Singleton

import androidx.room.Room
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DaoProvider {

    @Provides
    @Singleton
    fun getProvidePokemonDOA(data: AppDatabase): PokemonDAO {
        return data.pokemonDao()
    }

    @Provides
    @Singleton
    fun getProvideAppDATAbASE(application: Application): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(application,
                AppDatabase::class.java, "Cards").fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

}
