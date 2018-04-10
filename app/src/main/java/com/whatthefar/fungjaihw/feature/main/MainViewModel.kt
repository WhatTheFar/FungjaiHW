package com.whatthefar.fungjaihw.feature.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.whatthefar.fungjaihw.model.Music
import com.whatthefar.fungjaihw.model.Outcome
import com.whatthefar.fungjaihw.service.repository.MusicRepository
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Far on 20/3/2018 AD.
 */
class MainViewModel
@Inject constructor(
        private val musicRepository: MusicRepository
) : ViewModel() {

    init {
        Timber.wtf("MainViewModel init")
    }

    val musicListObservable: LiveData<Outcome<List<Music>>> by lazy {
        musicRepository.getMusics()
    }

}