package com.whatthefar.fungjaihw.feature.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.whatthefar.fungjaihw.R
import com.whatthefar.fungjaihw.data.model.Music
import com.whatthefar.fungjaihw.databinding.ItemTrackBinding
import com.whatthefar.fungjaihw.databinding.ItemZineBinding
import com.whatthefar.fungjaihw.data.model.Track
import com.whatthefar.fungjaihw.data.model.Zine

/**
 * Created by Far on 20/3/2018 AD.
 */
class MusicAdapter : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    var musicList: List<Music>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
        ))
    }

    override fun getItemCount(): Int {
        musicList?.let {
            return it.size
        }
        return 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (musicList!![position].type) {
            "track" -> R.layout.item_track
            "zine" -> R.layout.item_zine
            else -> R.layout.item_track
        }
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList!![position])
    }

    class MusicViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(music: Music) {
            if (music.type == "track") {
                (binding as ItemTrackBinding).track = Track(music)
            } else {
                (binding as ItemZineBinding).zine = Zine(music)
            }
        }
    }
}