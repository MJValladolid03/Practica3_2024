package com.marisma.practica3_2024.catalogo.adapter

import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marisma.practica3_2024.R
import com.marisma.practica3_2024.catalogo.song
import com.marisma.practica3_2024.databinding.ItemSongBinding


class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemSongBinding.bind(view)

    fun render(songModel: song, onClickListener: (song) -> Unit){
        binding.tvSongTitle.text = songModel.titulo
        binding.tvSongArtist.text = songModel.artista
        binding.tvSongYear.text = songModel.anno
        Glide.with(binding.ivSongImage.context).load(songModel.imagen).into(binding.ivSongImage)

        binding.root.setOnClickListener { onClickListener(songModel) }

        binding.tvSongTitle.typeface = ResourcesCompat.getFont(binding.root.context, R.font.font_momentz)
        binding.tvSongArtist.typeface = ResourcesCompat.getFont(binding.root.context, R.font.font_momentz)
        binding.tvSongYear.typeface = ResourcesCompat.getFont(binding.root.context, R.font.font_momentz)
    }
}

