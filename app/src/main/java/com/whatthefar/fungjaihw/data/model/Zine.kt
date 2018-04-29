package com.whatthefar.fungjaihw.data.model

import android.databinding.ObservableField
import com.whatthefar.fungjaihw.data.model.Music

/**
 * Created by Far on 21/3/2018 AD.
 */
data class Zine(
        val title: String?,
        val description: String?,
        val coverUrl: String?
)  {
    constructor(music: Music) : this(music.title, music.description, music.cover)
}
