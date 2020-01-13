package com.example.meyss.javaretrofitdagger

import android.content.Context
import android.graphics.BitmapFactory
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.databinding.ActivityMainBinding
import com.example.meyss.javaretrofitdagger.databinding.PokemonItemBinding
import java.io.IOException
import java.io.InputStream
import java.net.URL

class PokAdapter (private var poksList: List<Pokemon>, private  var context: Context): RecyclerView.Adapter<PokAdapter.ViewHolder>() {

    inner class ViewHolder( val pokItem: PokemonItemBinding) : RecyclerView.ViewHolder(pokItem.root) {

        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        //var img: ImageView
       // var nametext: TextView

        fun bind(obj: Any) {
            pokItem.setVariable(BR.pokemon, obj)
            pokItem.executePendingBindings()
        }
       // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.

    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokAdapter.ViewHolder {
       // val context = parent.context
      //  val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        //val pokView = inflater.inflate(R.layout.pokemon_item, parent, false)

        val binding = DataBindingUtil.inflate<PokemonItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.pokemon_item, parent, false)
        // Return a new holder instance
        return ViewHolder(binding as PokemonItemBinding)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: PokAdapter.ViewHolder, position: Int) {
        // Get the data model based on position

        val pok = poksList[position]
        viewHolder.bind(pok)
        //viewHolder.pokItem.setItemClickListener(this)
        // Set item views based on your views and data model
        /*val textView = viewHolder.nametext
        textView.text = pok.name
        val imageView = viewHolder.img

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        try {
            val url = URL(pok.imageUrl)
            imageView.setImageBitmap(BitmapFactory.decodeStream(url.content as InputStream))
        } catch (e: IOException) {
            Log.e("imageLoder", e.message)
        }*/


    }
    fun  setData(newData: List<Pokemon> ){
        this.poksList = newData
        notifyDataSetChanged()
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return poksList.size
    }
}
