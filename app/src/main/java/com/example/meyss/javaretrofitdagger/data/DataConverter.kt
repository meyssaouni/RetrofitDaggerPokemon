package com.example.meyss.javaretrofitdagger.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import androidx.room.TypeConverter

class DataConverter {

    @TypeConverter
    fun fromCountryLangList(attacks: List<Attack>?): String? {
        if (attacks == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Attack>>() {

        }.type
        return gson.toJson(attacks, type)
    }

    @TypeConverter
    fun toAttackList(AttackString: String?): List<Attack>? {
        if (AttackString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Attack>>() {

        }.type
        return gson.fromJson<List<Attack>>(AttackString, type)
    }
}