package com.example.meyss.javaretrofitdagger.Fragments

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meyss.javaretrofitdagger.Adapters.AttackAdapter
import com.example.meyss.javaretrofitdagger.viewModel.AttacksViewModel
import com.example.meyss.javaretrofitdagger.R
import com.example.meyss.javaretrofitdagger.di.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class AttacksFragment: Fragment() {


    companion object {
        fun newInstance() = AttacksFragment()
    }
    @Inject
    lateinit var viewmodelfactory : ViewModelFactory

    private lateinit var viewModel: AttacksViewModel

      var recycler : RecyclerView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.attacks_fragment, container, false)
         recycler = view.findViewById(R.id.AttackRC)
        recycler!!.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val id = arguments?.getString("pokId") as String
        val attacks = viewModel.getAttacks(id)
        recycler!!.adapter = AttackAdapter(attacks)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this,viewmodelfactory).get(AttacksViewModel::class.java)

    }

}
