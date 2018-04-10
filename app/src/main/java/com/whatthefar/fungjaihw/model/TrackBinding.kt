package com.whatthefar.fungjaihw.model

import android.databinding.ObservableField

/**
 * Created by Far on 21/3/2018 AD.
 */
class TrackBinding(music: Music)  {

    val coverUrl: ObservableField<String> = ObservableField()
    val title: ObservableField<String> = ObservableField()
    val artist: ObservableField<String> = ObservableField()

    init {
        coverUrl.set(music.cover)
        title.set(music.song)
        artist.set(music.artist)
    }
}
