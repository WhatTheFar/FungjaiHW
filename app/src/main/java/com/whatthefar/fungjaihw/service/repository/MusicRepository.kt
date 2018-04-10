package com.whatthefar.fungjaihw.service.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.whatthefar.fungjaihw.model.Music
import com.whatthefar.fungjaihw.model.Outcome
import com.whatthefar.fungjaihw.service.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by Far on 20/3/2018 AD.
 */
interface MusicRepository {
    fun getMusics(): LiveData<Outcome<List<Music>>>
}

class MusicRepositoryImpl(private val apiService: ApiService) : MusicRepository {

    val dataObservable: MutableLiveData<Outcome<List<Music>>> = MutableLiveData()

    override fun getMusics(): LiveData<Outcome<List<Music>>> {
        Timber.i("getMusic")
        apiService.getMusicList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            dataObservable.value = Outcome.success(it)
                        },
                        {
                            dataObservable.value = Outcome.failure(it)
                        }
                )
        return dataObservable
    }
}