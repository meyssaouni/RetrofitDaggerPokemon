package com.example.meyss.javaretrofitdagger.di;

import com.example.meyss.javaretrofitdagger.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public abstract class ActivityBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

}
