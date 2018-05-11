package com.whatthefar.fungjaihw.data.repository

import com.whatthefar.fungjaihw.common.networking.*
import com.whatthefar.fungjaihw.data.model.Music
import com.whatthefar.fungjaihw.data.remote.ApiService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by Far on 20/3/2018 AD.
 */

class MusicRepository
@Inject constructor(
        private val apiService: ApiService,
        private val scheduler: Scheduler
) {

    val dataFetchOutcome: PublishSubject<Outcome<List<Music>>> = PublishSubject.create<Outcome<List<Music>>>()

    fun fetchMusics(compositeDisposable: CompositeDisposable) {
        dataFetchOutcome.loading(true)
        apiService.getMusicList()
                .performOnBackOutOnMain(scheduler)
                .subscribe(
                        {
                            dataFetchOutcome.success(it)
                        },
                        {
                            dataFetchOutcome.failed(it)
                        }
                )
                .addTo(compositeDisposable)
    }
}