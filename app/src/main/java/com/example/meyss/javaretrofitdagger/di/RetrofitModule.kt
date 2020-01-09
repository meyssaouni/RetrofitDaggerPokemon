package com.example.meyss.javaretrofitdagger.di

import java.util.concurrent.TimeUnit

import javax.inject.Inject
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    internal val requestHeader: OkHttpClient
        @Provides
        @Singleton
        get() {

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder().build()
                chain.proceed(request)
            }
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)

            return httpClient.build()
        }


    @Provides
    @Singleton
    fun getRetrofitService(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        //if (retrofit == null) {
         return   Retrofit.Builder()
                    .baseUrl("https://api.pokemontcg.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
      //  }
      //  return retrofit
    }

    companion object {
        private var retrofit: Retrofit? = null
    }

}