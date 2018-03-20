package com.whatthefar.fungjaihw.model

import android.databinding.ObservableField

/**
 * Created by Far on 21/3/2018 AD.
 */
class ZineBinding(music: Music) {

    val coverUrl: ObservableField<String> = ObservableField()
    val title: ObservableField<String> = ObservableField()
    val description: ObservableField<String> = ObservableField()

    init {
        coverUrl.set(music.cover)
        title.set(music.title)
        description.set(music.description)
    }

}