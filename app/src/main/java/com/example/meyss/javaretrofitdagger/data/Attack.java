package com.example.meyss.javaretrofitdagger.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class Attack {
    @PrimaryKey
    public int attackId ;
    public String name;
    public String text;
    public  String damage;
    public String pokId;
    public int convertedEnergyCost;

    public int getAttackId() {
        return attackId;
    }

    public String getPokId() {
        return pokId;
    }

    public void setPokId(String pokId) {
        this.pokId = pokId;
    }

    public void setAttackId(int attackId) {
        this.attackId = attackId;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "attackId=" + attackId +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", damage='" + damage + '\'' +
                ", pokId='" + pokId + '\'' +
                ", convertedEnergyCost=" + convertedEnergyCost +
                '}';
    }
}
