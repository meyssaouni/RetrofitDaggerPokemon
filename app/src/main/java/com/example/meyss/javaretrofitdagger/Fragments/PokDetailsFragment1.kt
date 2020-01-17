package com.example.meyss.javaretrofitdagger.Fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.meyss.javaretrofitdagger.EventBus.CardDetailEvent
import com.example.meyss.javaretrofitdagger.R
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.databinding.PokDetailsFragment1FragmentBinding
import com.example.meyss.javaretrofitdagger.viewModel.PokDetailsFragment1ViewModel
import org.greenrobot.eventbus.EventBus

class PokDetailsFragment1 : Fragment() {

    companion object {
        fun newInstance() = PokDetailsFragment1()
    }

    private lateinit var viewModel: PokDetailsFragment1ViewModel
     var img: ImageView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<PokDetailsFragment1FragmentBinding>(
                LayoutInflater.from(context),
                R.layout.pok_details_fragment1_fragment,container, false)
        val pk = arguments?.getSerializable("pokemon") as Pokemon?

        img = binding.root.findViewById(R.id.imgDetails)
        img!!.setOnClickListener {

            val pokToSend =  CardDetailEvent(pk)
            EventBus.getDefault().postSticky(pokToSend)
        }

        binding.pokemon = pk
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PokDetailsFragment1ViewModel::class.java)
        // TODO: Use the ViewMode
    }





}
