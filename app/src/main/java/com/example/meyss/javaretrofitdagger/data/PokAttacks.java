package com.example.meyss.javaretrofitdagger.data;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class PokAttacks {
    @Embedded
    public Pokemon pok;
    @Relation(
            parentColumn = "id",
            entityColumn = "pokId"
               )
    public List<Attack> attacks;

    @Override
    public String toString() {
        return "PokAttacks{" +
                "pok=" + pok +
                ", attacks=" + attacks +
                '}';
    }
}
