package com.example.meyss.javaretrofitdagger.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.meyss.javaretrofitdagger.Repository.PokemonRepo
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.data.PokemonList
import com.example.meyss.javaretrofitdagger.di.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ActivityViewModel @Inject constructor(var repo: PokemonRepo, var api: ApiInterface) : ViewModel() {


    fun getAllPoks(): LiveData<List<Pokemon>>{

            return repo.allPoks

    }

    fun getAllPoksAPI(){

        api.listPokemeon().enqueue(object : Callback<PokemonList> {
            override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                val result = response.body()

                if (result != null) {
                    //retrofit
                    println("pokemons:" + result.poks!!.toString())
                    //room
                   var i = 0
                    for (pok in result.poks!!) {
                        println(pok.id)
                        println(i)
                        if (pok.id.equals("hgss2-90")) {
                            i++
                            println("hgss2-90: "+i)

                        } else {
                            println(pok.attacks)
                            for (a in pok.attacks!!) {
                               // a.pokId = pok.id
                                a.attackId = i
                                println("AttackID: "+a.attackId)

                                i++
                                println("incremented " +i)
                            }
                            repo.insertAttack(pok.attacks!!)
                            println(" attatcks inserted")
                        }
                    }
                    repo.insertPok(result.poks!!)
                    println("room relations")
                    println(repo.attacks)

                }
            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

}