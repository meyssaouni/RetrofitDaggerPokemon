package com.example.meyss.javaretrofitdagger.di

import android.app.Application

import com.example.meyss.javaretrofitdagger.Activities.MainActivity
import com.example.meyss.javaretrofitdagger.Activities.PokDetails
import com.example.meyss.javaretrofitdagger.Fragments.AttacksFragment

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Singleton
@Component(modules = [RetrofitModule::class, DaoProvider::class, AndroidInjectionModule::class, ActivityBuilderModule::class,ViewModuleModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApp: App)
}
