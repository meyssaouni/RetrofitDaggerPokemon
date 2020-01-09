package com.example.meyss.javaretrofitdagger.di

import android.app.Application

import com.example.meyss.javaretrofitdagger.MainActivity

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [RetrofitModule::class, DaoProvider::class, AndroidInjectionModule::class, ActivityBuilderModule::class])
interface AppComponent {
    fun inject(clas: MainActivity)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApp: App)
}
