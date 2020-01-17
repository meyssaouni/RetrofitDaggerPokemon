package com.example.meyss.javaretrofitdagger.di

import com.example.meyss.javaretrofitdagger.Activities.MainActivity
import com.example.meyss.javaretrofitdagger.Activities.PokDetails
import com.example.meyss.javaretrofitdagger.Fragments.AttacksFragment
import com.example.meyss.javaretrofitdagger.Fragments.PokDetailsFragment1

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector//(modules = [FragmentBuilderModule::class])
     abstract fun mainActivity(): MainActivity


    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
     abstract fun pokDetails(): PokDetails



}
