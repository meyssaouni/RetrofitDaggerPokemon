package com.example.meyss.javaretrofitdagger.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter
import java.io.Serializable

@Entity
class Pokemon : Serializable {
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

    // important code for loading image here
    companion object {
        @JvmStatic
        @BindingAdapter("avatar")
        fun loadImage(imageView: ImageView?, imageURL: String?) {
            Glide.with(imageView!!.getContext())
                    //.setDefaultRequestOptions(RequestOptions()
                     //       .circleCrop())
                    .load(imageURL)
                    .into(imageView!!)
        }
    }
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
              //  ", attacks=" + attacks +
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
