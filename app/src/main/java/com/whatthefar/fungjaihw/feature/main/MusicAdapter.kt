package com.whatthefar.fungjaihw.feature.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.recyclerview.extensions.AsyncDifferConfig
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
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
class MusicAdapter :
        ListAdapter<Music, MusicAdapter.MusicViewHolder>(
                AsyncDifferConfig
                        .Builder(MusicDiffCallback())
                        .build()
        ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder =
            MusicViewHolder(
                    DataBindingUtil.inflate(
                            LayoutInflater.from(parent.context),
                            viewType,
                            parent,
                            false
                    )
            )

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).type) {
            Music.TRACK -> R.layout.item_track
            Music.ZINE -> R.layout.item_zine
            else -> R.layout.item_track
        }
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MusicViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(music: Music) {
            when (binding) {
                is ItemTrackBinding -> binding.track = Track(music)
                is ItemZineBinding -> binding.zine = Zine(music)
            }
        }
    }

    class MusicDiffCallback : DiffUtil.ItemCallback<Music>() {
        override fun areItemsTheSame(oldItem: Music, newItem: Music): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Music, newItem: Music): Boolean {
            return oldItem == newItem
        }
    }
}