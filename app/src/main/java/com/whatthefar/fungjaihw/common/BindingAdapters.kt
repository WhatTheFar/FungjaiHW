package com.whatthefar.fungjaihw.common

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Far on 20/3/2018 AD.
 */
@BindingAdapter("url")
fun bindImageToImageView(view: ImageView, url: String?) {
    when (url) {
        is String -> {
            Glide.with(view.context)
                    .load(url)
                    .into(view)
        }
    }
}