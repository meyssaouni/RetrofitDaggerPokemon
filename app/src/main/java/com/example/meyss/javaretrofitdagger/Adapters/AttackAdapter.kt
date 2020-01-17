package com.example.meyss.javaretrofitdagger.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meyss.javaretrofitdagger.R
import com.example.meyss.javaretrofitdagger.data.Attack

class AttackAdapter(val attackList : List<Attack>) : RecyclerView.Adapter<AttackAdapter.ViewHolder>(){


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var nom: TextView
        var damage : TextView
        var convEn : TextView
        var text : TextView

        init {

            nom = itemView.findViewById<View>(R.id.atName) as TextView
            damage = itemView.findViewById<View>(R.id.atDamage) as TextView
            convEn = itemView.findViewById<View>(R.id.atConvEn) as TextView
            text = itemView.findViewById<View>(R.id.atText) as TextView


        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttackAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //println("iciiii adapter")
        // Inflate the custom layout
        val attView = inflater.inflate(R.layout.attack_item, parent, false)

        // Return a new holder instance
        return ViewHolder(attView)    }

    override fun getItemCount(): Int {
        return attackList.size
    }

    override fun onBindViewHolder(holder: AttackAdapter.ViewHolder, position: Int) {

        val attack = attackList[position]

        // Set item views based on your views and data model
        val nameTXT = holder.nom
        nameTXT.text = attack.name
        val damageTxt = holder.damage
        damageTxt.text = attack.damage
        val convEnTxt = holder.convEn
        convEnTxt.text = attack.convertedEnergyCost.toString()
        val textTxT = holder.text
        textTxT.text = attack.text




    }
}