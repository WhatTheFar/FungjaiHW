package com.whatthefar.fungjaihw.di

import com.whatthefar.fungjaihw.feature.main.MainViewModelFactory
import com.whatthefar.fungjaihw.service.repository.MusicRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Far on 20/3/2018 AD.
 */
@Module
class MainActivityModule {

    @Provides
    fun providesMainViewModelFactory(musicRepository: MusicRepository): MainViewModelFactory = MainViewModelFactory(musicRepository)
}