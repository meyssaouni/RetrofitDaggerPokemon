package com.example.meyss.javaretrofitdagger.di

import com.example.meyss.javaretrofitdagger.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

}
