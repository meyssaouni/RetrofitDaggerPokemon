package com.example.meyss.javaretrofitdagger.viewModel

import androidx.lifecycle.ViewModel
import com.example.meyss.javaretrofitdagger.Repository.PokemonRepo
import com.example.meyss.javaretrofitdagger.data.Attack
import javax.inject.Inject

class AttacksViewModel @Inject constructor(var repo: PokemonRepo) : ViewModel() {
    fun getAttacks(idPok: String): List<Attack>{

        return repo.getAttacksIdPok(idPok)
    }
}
