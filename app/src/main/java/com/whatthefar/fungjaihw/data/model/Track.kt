package com.whatthefar.fungjaihw.data.model

import android.databinding.ObservableField
import com.whatthefar.fungjaihw.data.model.Music

/**
 * Created by Far on 21/3/2018 AD.
 */
data class Track(
        val title: String?,
        val artist: String?,
        val coverUrl: String?
) {
    constructor(music: Music) : this(music.song, music.artist, music.cover)
}
