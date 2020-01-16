package com.example.meyss.javaretrofitdagger.di

import com.example.meyss.javaretrofitdagger.MainActivity
import com.example.meyss.javaretrofitdagger.PokDetails
import com.example.meyss.javaretrofitdagger.ui.pokdetailsfragment1.PokDetailsFragment1

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun pokDetails(): PokDetails


    @ContributesAndroidInjector
    internal abstract fun pokDetails1(): PokDetailsFragment1

}
