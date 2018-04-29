package com.whatthefar.fungjaihw.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.whatthefar.fungjaihw.data.model.Music
import com.whatthefar.fungjaihw.common.networking.Outcome
import com.whatthefar.fungjaihw.common.networking.failed
import com.whatthefar.fungjaihw.common.networking.loading
import com.whatthefar.fungjaihw.common.networking.success
import com.whatthefar.fungjaihw.data.remote.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import timber.log.Timber

/**
 * Created by Far on 20/3/2018 AD.
 */
interface MusicRepository {
    val dataFetchOutcome: PublishSubject<Outcome<List<Music>>>
    fun getMusics()
}

class MusicRepositoryImpl(private val apiService: ApiService) : MusicRepository {

    override val dataFetchOutcome: PublishSubject<Outcome<List<Music>>> = PublishSubject.create<Outcome<List<Music>>>()

    override fun getMusics() {
        dataFetchOutcome.loading(true)
        apiService.getMusicList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            dataFetchOutcome.success(it)
                        },
                        {
                            dataFetchOutcome.failed(it)
                        }
                )
    }
}