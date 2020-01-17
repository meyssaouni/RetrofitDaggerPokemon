package com.example.meyss.javaretrofitdagger.data

import androidx.room.Embedded
import androidx.room.Relation

class PokAttacks {
    @Embedded
    var pok: Pokemon? = null
    @Relation(parentColumn = "id", entityColumn = "pokId")
    var attacks: List<Attack>? = null

    override fun toString(): String {
        return "PokAttacks{" +
                "pok=" + pok +
                ", attacks=" + attacks +
                '}'
    }
}
