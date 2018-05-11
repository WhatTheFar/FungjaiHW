package com.whatthefar.fungjaihw.feature.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.whatthefar.fungjaihw.common.networking.Outcome
import com.whatthefar.fungjaihw.common.networking.toLiveData
import com.whatthefar.fungjaihw.data.model.Music
import com.whatthefar.fungjaihw.data.repository.MusicRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Far on 20/3/2018 AD.
 */
class MainViewModel
@Inject constructor(
        private val musicRepo: MusicRepository,
        private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    val musicListObservable: LiveData<Outcome<List<Music>>> by lazy {
        musicRepo.dataFetchOutcome.toLiveData(compositeDisposable)
    }

    fun getMusics() {
        musicRepo.fetchMusics(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}