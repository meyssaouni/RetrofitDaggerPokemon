package com.example.meyss.javaretrofitdagger.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonList {
    @SerializedName("cards")
    private List<Pokemon> poks;

    public List<Pokemon> getPoks() {
        return poks;
    }

    public void setPoks(List<Pokemon> poks) {
        this.poks = poks;
    }
}
