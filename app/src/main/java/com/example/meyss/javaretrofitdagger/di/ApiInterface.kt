package com.example.meyss.javaretrofitdagger.di

import com.example.meyss.javaretrofitdagger.data.PokemonList

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("v1/cards?types=fire")
    fun listPokemeon(): Call<PokemonList>
}
