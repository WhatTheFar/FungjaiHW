package com.whatthefar.fungjaihw.di

import android.app.Application
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.whatthefar.fungjaihw.data.remote.ApiService
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import com.whatthefar.fungjaihw.common.networking.AppScheduler
import com.whatthefar.fungjaihw.common.networking.Scheduler
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Far on 20/3/2018 AD.
 */
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application) = application.applicationContext

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun provideScheduler(): Scheduler = AppScheduler()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit
            .Builder()
            .baseUrl("https://us-central1-fjawesomeintern.cloudfunctions.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}