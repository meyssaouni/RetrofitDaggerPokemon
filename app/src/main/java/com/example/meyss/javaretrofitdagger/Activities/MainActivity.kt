package com.example.meyss.javaretrofitdagger.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.meyss.javaretrofitdagger.Repository.PokemonRepo
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.di.ApiInterface
import com.example.meyss.javaretrofitdagger.di.ViewModelFactory
import com.example.meyss.javaretrofitdagger.viewModel.ActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.meyss.javaretrofitdagger.PokAdapter
import com.example.meyss.javaretrofitdagger.R
import com.example.meyss.javaretrofitdagger.databinding.ActivityMainBinding
import com.example.meyss.javaretrofitdagger.iOnPokemonClicked


class MainActivity : AppCompatActivity(),CoroutineScope, iOnPokemonClicked {
    override fun clickedPok(pok: Pokemon) {
        val intent = Intent(this, PokDetails::class.java).putExtra("pokemon",pok)
        startActivity(intent)
    }

    private val job = Job()

    @Inject
    lateinit var viewmodelfactory : ViewModelFactory

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

       // setContentView(R.layout.activity_main)

        val pokRC = activityMainBinding.PokRecycler
        pokRC.layoutManager = GridLayoutManager(applicationContext, 2)

        val viewmodel = ViewModelProviders.of(this,viewmodelfactory).get(ActivityViewModel::class.java)

        launch(Dispatchers.Main){
            async(Dispatchers.IO){
                viewmodel.getAllPoksAPI()
            }.await()


        }

        val pokObserver = Observer<List<Pokemon>> {poks-> pokRC.adapter = PokAdapter(poks, this).apply { setOnPokemonClicked(this@MainActivity) }}
        viewmodel.getAllPoks().observe(this,pokObserver)



    }

}
