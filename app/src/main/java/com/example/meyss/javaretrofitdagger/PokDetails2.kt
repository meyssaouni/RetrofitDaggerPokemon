package com.example.meyss.javaretrofitdagger

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyss.javaretrofitdagger.viewModel.PokDetails2ViewModel


class PokDetails2 : Fragment() {

    companion object {
        fun newInstance() = PokDetails2()
    }

    private lateinit var viewModel: PokDetails2ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.pok_details2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PokDetails2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
