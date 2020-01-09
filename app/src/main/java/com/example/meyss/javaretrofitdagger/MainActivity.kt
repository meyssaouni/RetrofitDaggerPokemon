package com.example.meyss.javaretrofitdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import com.example.meyss.javaretrofitdagger.Repository.PokemonRepo
import com.example.meyss.javaretrofitdagger.data.Attack
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.data.PokemonList
import com.example.meyss.javaretrofitdagger.di.ApiInterface
import com.example.meyss.javaretrofitdagger.di.App

import javax.inject.Inject

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.AndroidInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    @Inject
     var apiInterface: ApiInterface? = null
    @Inject
     var repo: PokemonRepo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pokRC = findViewById<View>(R.id.PokRecycler) as RecyclerView
        //App.getAppComponent().inject(this);


        apiInterface!!.listPokemeon().enqueue(object : Callback<PokemonList> {
            override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {

                val result = response.body()

                if (result != null) {
                    //retrofit
                    println("pokemons:" + result.poks!!.toString())
                    val pokAdapter = PokAdapter(result.poks!!, applicationContext)
                    pokRC.adapter = pokAdapter
                    pokRC.layoutManager = GridLayoutManager(applicationContext, 2)
                    //room

                    // PokemonRepo repo = new PokemonRepo(context);
                    var i = 0
                    for (pok in result.poks!!) {
                        println(pok.id)
                        if (pok.id == "hgss2-90") {
                            i++

                        } else {
                            for (a in pok.attacks!!) {
                                a.pokId = pok.id
                                a.attackId = i
                                i++
                            }
                            repo!!.insertAttack(pok.attacks!!)
                            println(" attatcks inserted")
                        }

                    }
                    repo!!.insertPok(result.poks!!)
                    println("room relations")
                    println(repo!!.attacks)

                }
            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                t.printStackTrace()
            }
        })
        //System.out.println( apiInterface.listPokemeon().enqueue(new););
        // Log.e("my retrofit", apiInterface.listPokemeon().toString());

    }
}
