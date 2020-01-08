package com.example.meyss.javaretrofitdagger.di;

import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class App extends Application implements HasAndroidInjector {

    private static  AppComponent appComponent;
   /* public static AppComponent getAppComponent(){
        return appComponent;
    }*/
    @Override
    public void onCreate() {
        super.onCreate();
        //appComponent=b uildComponent();
        DaggerAppComponent.builder().application(this)
                .build().inject(this);

    }

    @Inject
    DispatchingAndroidInjector<Object> dispacher;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispacher;
    }
   /* protected AppComponent buildComponent(){
        return
                DaggerAppComponent.builder()
                        .retrofitModule(new RetrofitModule())
                        .build();
    }*/
}
