package com.whatthefar.fungjaihw.di

import com.whatthefar.fungjaihw.feature.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Far on 20/3/2018 AD.
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (BuildersModule::class), (ViewModelModule::class)])
interface AppComponent {
    fun inject(app: App)
}