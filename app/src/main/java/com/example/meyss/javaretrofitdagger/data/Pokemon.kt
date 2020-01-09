package com.example.meyss.javaretrofitdagger.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
class Pokemon {
    @PrimaryKey
    var id: String = "0"
    var name: String? = null
    var nationalPokedexNumber: Int = 0
    var imageUrl: String? = null
    var imageUrlHires: String? = null

    var supertype: String? = null
    var subtype: String? = null
    var hp: String? = null
    //tab
    @TypeConverters(DataConverter::class)
    var attacks: List<Attack>? = null
    var convertedRetreatCost: Int = 0
    var number: String? = null
    var artist: String? = null
    var rarity: String? = null
    var series: String? = null
    var set: String? = null
    var setCode: String? = null

    override fun toString(): String {
        return "Pokemon{" +
                "id='" + id + '\''.toString() +
                ", name='" + name + '\''.toString() +
                ", nationalPokedexNumber=" + nationalPokedexNumber +
                ", imageUrl='" + imageUrl + '\''.toString() +
                ", ImageUrlHires='" + imageUrlHires + '\''.toString() +
                ", supertype='" + supertype + '\''.toString() +
                ", subtype='" + subtype + '\''.toString() +
                ", hp='" + hp + '\''.toString() +
                ", attacks=" + attacks +
                ", convertedRetreatCost=" + convertedRetreatCost +
                ", number='" + number + '\''.toString() +
                ", artist='" + artist + '\''.toString() +
                ", rarity='" + rarity + '\''.toString() +
                ", series='" + series + '\''.toString() +
                ", set='" + set + '\''.toString() +
                ", setCode='" + setCode + '\''.toString() +
                '}'.toString()
    }
}
