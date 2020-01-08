package com.example.meyss.javaretrofitdagger.data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import androidx.room.TypeConverter;

public class DataConverter {

    @TypeConverter
    public String fromCountryLangList(List<Attack> attacks) {
        if (attacks == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Attack>>() {}.getType();
        String json = gson.toJson(attacks, type);
        return json;
    }

    @TypeConverter
    public List<Attack> toAttackList(String AttackString) {
        if (AttackString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Attack>>() {}.getType();
        List<Attack> AttackList = gson.fromJson(AttackString, type);
        return AttackList;
    }
}