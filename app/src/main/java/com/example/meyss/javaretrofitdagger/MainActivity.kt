package com.example.meyss.javaretrofitdagger

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.databinding.ViewDataBinding
import com.example.meyss.javaretrofitdagger.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),CoroutineScope{
    private val job = Job()

    @Inject
    lateinit var apiInterface: ApiInterface
    @Inject
     lateinit var repo: PokemonRepo



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
        //App.getAppComponent().inject(this);

        val viewmodel = ViewModelProviders.of(this,viewmodelfactory).get(ActivityViewModel::class.java)
       // viewmodel.getAllPoksAPI()

        launch(Dispatchers.Main){
            async(Dispatchers.IO){
                viewmodel.getAllPoksAPI()
            }.await()


        }

        val pokObserver = Observer<List<Pokemon>> {poks-> pokRC.adapter = PokAdapter(poks,applicationContext) }
        viewmodel.getAllPoks().observe(this,pokObserver)



    }


}
