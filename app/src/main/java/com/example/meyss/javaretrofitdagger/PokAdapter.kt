package com.example.meyss.javaretrofitdagger

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.meyss.javaretrofitdagger.Repository.PokemonRepo
import com.example.meyss.javaretrofitdagger.data.Attack
import com.example.meyss.javaretrofitdagger.data.Pokemon

import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.net.URL
import androidx.recyclerview.widget.RecyclerView

class PokAdapter(// Store a member variable for the contacts
        private var poksList: List<Pokemon>, private val context: Context) : RecyclerView.Adapter<PokAdapter.ViewHolder>() {


    inner class ViewHolder// We also create a constructor that accepts the entire item row
    // and does the view lookups to find each subview
    (itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        var img: ImageView
        var nametext: TextView

        init {

            nametext = itemView.findViewById<View>(R.id.PokName) as TextView
            img = itemView.findViewById<View>(R.id.pokImg) as ImageView
        }// Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        println("iciiii adapter")
        // Inflate the custom layout
        val pokView = inflater.inflate(R.layout.pokemon_item, parent, false)

        // Return a new holder instance
        return ViewHolder(pokView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: PokAdapter.ViewHolder, position: Int) {
        // Get the data model based on position

        val pok = poksList[position]

        // Set item views based on your views and data model
        val textView = viewHolder.nametext
        textView.text = pok.name
        val imageView = viewHolder.img

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        try {
            val url = URL(pok.imageUrl)
            imageView.setImageBitmap(BitmapFactory.decodeStream(url.content as InputStream))
        } catch (e: IOException) {
            Log.e("imageLoder", e.message)
        }


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
