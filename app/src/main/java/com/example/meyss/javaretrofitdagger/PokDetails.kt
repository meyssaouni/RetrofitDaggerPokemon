package com.example.meyss.javaretrofitdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meyss.javaretrofitdagger.EventBus.CardDetailEvent
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.ui.pokdetailsfragment1.PokDetailsFragment1
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class PokDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pok_details_activity)
        val pokemon = intent?.extras!!.get("pokemon") as Pokemon
        val bundle = Bundle().apply { putSerializable("pokemon",pokemon) }
        val pokImg = PokDetailsFragment1.newInstance()
        pokImg.arguments =bundle
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, pokImg)
                    .commitNow()
        }
    }
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    fun onPokEvent(pokEvent: CardDetailEvent){
       // Toast.makeText(context, "You clicked " + pokEvent.pok, Toast.LENGTH_LONG).show()
        val pokdetails = PokDetails2.newInstance()
        val bundle = Bundle().apply { putSerializable("pokemon",pokEvent.pok) }
        pokdetails.arguments =bundle
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, pokdetails)
                .commitNow()
    }

}
