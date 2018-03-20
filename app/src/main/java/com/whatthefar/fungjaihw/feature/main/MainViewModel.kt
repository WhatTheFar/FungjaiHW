package com.whatthefar.fungjaihw.feature.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.whatthefar.fungjaihw.model.Music
import com.whatthefar.fungjaihw.service.repository.MusicRepository
import timber.log.Timber

/**
 * Created by Far on 20/3/2018 AD.
 */
class MainViewModel(val musicRepository: MusicRepository) : ViewModel() {

    init {
        Timber.wtf("MainViewModel init")
    }

    val musicListObservable: LiveData<List<Music>>
        get() = musicRepository.getMusics()

}