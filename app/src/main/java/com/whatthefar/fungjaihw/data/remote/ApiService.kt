package com.whatthefar.fungjaihw.data.remote

import com.whatthefar.fungjaihw.data.model.Music
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Far on 20/3/2018 AD.
 */
interface ApiService {

    @GET("musiclist")
    fun getMusicList(): Observable<List<Music>>
}