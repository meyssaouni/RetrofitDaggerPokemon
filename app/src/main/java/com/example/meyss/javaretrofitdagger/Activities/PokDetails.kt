package com.example.meyss.javaretrofitdagger.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.meyss.javaretrofitdagger.EventBus.CardDetailEvent
import com.example.meyss.javaretrofitdagger.Fragments.PokDetails2
import com.example.meyss.javaretrofitdagger.R
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.Fragments.PokDetailsFragment1
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class PokDetails : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var dispacher: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> {
        return dispacher
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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
        val pokdetailsFragment = PokDetails2.newInstance()
        val bundle = Bundle().apply { putSerializable("pokemon",pokEvent.pok) }
        pokdetailsFragment.arguments =bundle
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, pokdetailsFragment)
                .commitNow()
    }


}
