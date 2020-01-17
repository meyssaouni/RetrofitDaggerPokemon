package com.example.meyss.javaretrofitdagger.di

import com.example.meyss.javaretrofitdagger.Fragments.AttacksFragment
import com.example.meyss.javaretrofitdagger.Fragments.PokDetailsFragment1
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {


    @ContributesAndroidInjector
    internal abstract fun pokDetails1(): PokDetailsFragment1

    @ContributesAndroidInjector
    internal abstract fun attackFragment(): AttacksFragment
}