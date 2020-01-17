package com.example.meyss.javaretrofitdagger.Fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.meyss.javaretrofitdagger.R
import com.example.meyss.javaretrofitdagger.data.Pokemon
import com.example.meyss.javaretrofitdagger.databinding.PokDetails2FragmentBinding
import com.example.meyss.javaretrofitdagger.viewModel.PokDetails2ViewModel


class PokDetails2 : Fragment() {

    companion object {
        fun newInstance() = PokDetails2()
    }

    private lateinit var viewModel: PokDetails2ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<PokDetails2FragmentBinding>(
                LayoutInflater.from(context),
                R.layout.pok_details2_fragment,container, false)
        val pk = arguments?.getSerializable("pokemon") as Pokemon?
        binding.pokemon = pk
        val btn = binding.attacks
        btn.setOnClickListener{

            val attackF= AttacksFragment.newInstance()
            val bundle = Bundle().apply { putString("pokId",pk!!.id) }
            attackF.arguments =bundle
                Toast.makeText(context,"id: "+ pk!!.id,Toast.LENGTH_LONG).show()
          activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.container, attackF)
                    .commit()
        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PokDetails2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
