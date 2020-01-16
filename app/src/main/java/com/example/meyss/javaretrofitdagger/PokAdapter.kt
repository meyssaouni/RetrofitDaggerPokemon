package com.example.meyss.javaretrofitdagger

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.meyss.javaretrofitdagger.EventBus.PokEvent
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.databinding.ActivityMainBinding
import com.example.meyss.javaretrofitdagger.databinding.PokemonItemBinding
import org.greenrobot.eventbus.EventBus
import java.io.IOException
import java.io.InputStream
import java.net.URL

class PokAdapter(private var poksList: List<Pokemon>, private var context: Context) : RecyclerView.Adapter<PokAdapter.ViewHolder>() {

    var iOnPokemon :iOnPokemonClicked? = null

    fun setOnPokemonClicked(i : iOnPokemonClicked){
            this.iOnPokemon = i
        }
    inner class ViewHolder(val pokItem: PokemonItemBinding) : RecyclerView.ViewHolder(pokItem.root) {


        fun bind(obj: Any) {
            pokItem.setVariable(BR.pokemon, obj)
            pokItem.executePendingBindings()
        }

    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokAdapter.ViewHolder {

        val binding = DataBindingUtil.inflate<PokemonItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.pokemon_item, parent, false)
        // Return a new holder instance
        return ViewHolder(binding as PokemonItemBinding)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: PokAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val pok : Pokemon = poksList[position]
        viewHolder.bind(pok)
        viewHolder.itemView.setOnClickListener {
            if (iOnPokemon!=null)
            {
             iOnPokemon!!.clickedPok(pok)

            }
           // val pokToSend =  PokEvent(pok)
          //  EventBus.getDefault().postSticky(pokToSend)

        }

    }

    fun setData(newData: List<Pokemon>) {
        this.poksList = newData
        notifyDataSetChanged()
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return poksList.size
    }



}
