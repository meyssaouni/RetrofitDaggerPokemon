package com.example.meyss.javaretrofitdagger.di;

import android.app.Application;

import com.example.meyss.javaretrofitdagger.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class,DaoProvider.class})
public interface AppComponent {
    void inject(MainActivity clas);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(App myApp);
}
