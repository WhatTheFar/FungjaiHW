package com.whatthefar.fungjaihw.service.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.whatthefar.fungjaihw.model.Music
import com.whatthefar.fungjaihw.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by Far on 20/3/2018 AD.
 */
interface MusicRepository {
    fun getMusics(): LiveData<List<Music>>
}

class MusicRepositoryImpl(private val apiService : ApiService) : MusicRepository {

    val dataObservable: MutableLiveData<List<Music>> = MutableLiveData()

    override fun getMusics(): LiveData<List<Music>> {
        Timber.wtf("getMusic")
        apiService.getMusicList().enqueue(object : Callback<List<Music>> {
            override fun onFailure(call: Call<List<Music>>?, t: Throwable?) {
                Timber.wtf("onFailure : getMusics")
                Timber.wtf(t)
            }

            override fun onResponse(call: Call<List<Music>>?, response: Response<List<Music>>?) {
                Timber.wtf("onResponse : getMusics")
                dataObservable.value = response?.body()
            }
        })
        return dataObservable
    }
}