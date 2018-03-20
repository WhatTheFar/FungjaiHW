package com.whatthefar.fungjaihw.di

import android.app.Application
import com.whatthefar.fungjaihw.service.ApiService
import com.whatthefar.fungjaihw.service.repository.MusicRepository
import com.whatthefar.fungjaihw.service.repository.MusicRepositoryImpl
import dagger.Module
import dagger.Provides
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
    fun provideMusicRepository(apiService: ApiService): MusicRepository = MusicRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit
            .Builder()
            .baseUrl("https://us-central1-fjawesomeintern.cloudfunctions.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideNewsService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}