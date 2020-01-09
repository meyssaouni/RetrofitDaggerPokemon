package com.example.meyss.javaretrofitdagger.data

import com.google.gson.annotations.SerializedName

class PokemonList {
    @SerializedName("cards")
    var poks: List<Pokemon>? = null
}
