package com.whatthefar.fungjaihw.di


import com.whatthefar.fungjaihw.feature.main.MainActivity
import com.whatthefar.fungjaihw.feature.main.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Far on 20/3/2018 AD.
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

}