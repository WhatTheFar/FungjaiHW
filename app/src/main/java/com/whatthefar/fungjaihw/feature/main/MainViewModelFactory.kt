package com.whatthefar.fungjaihw.feature.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.whatthefar.fungjaihw.service.repository.MusicRepository

/**
 * Created by Far on 20/3/2018 AD.
 */
class MainViewModelFactory(val musicRepository: MusicRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(musicRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}