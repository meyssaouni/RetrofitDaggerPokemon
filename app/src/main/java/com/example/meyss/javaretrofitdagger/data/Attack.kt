package com.example.meyss.javaretrofitdagger.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Attack {
    @PrimaryKey
    var attackId: Int = 0
    var name: String? = null
    var text: String? = null
    var damage: String? = null
    var pokId: String = "leak"
    var convertedEnergyCost: Int = 0

    override fun toString(): String {
        return "Attack{" +
                "attackId=" + attackId +
                ", name='" + name + '\''.toString() +
                ", text='" + text + '\''.toString() +
                ", damage='" + damage + '\''.toString() +
                ", pokId='" + pokId + '\''.toString() +
                ", convertedEnergyCost=" + convertedEnergyCost +
                '}'.toString()
    }
}
