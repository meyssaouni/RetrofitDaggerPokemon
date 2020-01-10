package com.example.meyss.javaretrofitdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

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
import com.example.meyss.javaretrofitdagger.di.ViewModelFactory
import com.example.meyss.javaretrofitdagger.viewModel.ActivityViewModel
import dagger.android.AndroidInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiInterface: ApiInterface
    @Inject
     lateinit var repo: PokemonRepo
@Inject
lateinit var viewmodelfactory : ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pokRC = findViewById<View>(R.id.PokRecycler) as RecyclerView
        pokRC.layoutManager = GridLayoutManager(applicationContext, 2)
        //App.getAppComponent().inject(this);

        val viewmodel = ViewModelProviders.of(this,viewmodelfactory).get(ActivityViewModel::class.java)
        viewmodel.getAllPoksAPI()

        val pokObserver = Observer<List<Pokemon>> {poks-> pokRC.adapter = PokAdapter(poks,applicationContext) }
        viewmodel.getAllPoks().observe(this,pokObserver)



    }
}
