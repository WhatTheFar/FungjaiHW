package com.whatthefar.fungjaihw.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Far on 20/3/2018 AD.
 */

data class Music(
        @SerializedName("artist") var artist: String? = null,
        @SerializedName("cover") var cover: String? = null,
        @SerializedName("song") var song: String? = null,
        @SerializedName("type") var type: String? = null,
        @SerializedName("description") var description: String? = null,
        @SerializedName("title") var title: String? = null,
        @SerializedName("url") var url: String? = null
) {
    companion object {
        const val ZINE = "zine"
        const val TRACK = "track"
    }
}