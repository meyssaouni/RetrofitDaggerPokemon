package com.example.meyss.javaretrofitdagger.di

import android.app.Application

import javax.inject.Inject

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class App : Application(), HasAndroidInjector {

    @Inject
     public var dispacher: DispatchingAndroidInjector<Any>? = null

    /* public static AppComponent getAppComponent(){
        return appComponent;
    }*/
    override fun onCreate() {
        super.onCreate()
        //appComponent=b uildComponent();
        DaggerAppComponent.builder().application(this)
                .build().inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return dispacher
    }

    companion object {

        private val appComponent: AppComponent? = null
    }
    /* protected AppComponent buildComponent(){
        return
                DaggerAppComponent.builder()
                        .retrofitModule(new RetrofitModule())
                        .build();
    }*/
}
