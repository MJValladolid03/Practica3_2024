package com.marisma.practica3_2024.catalogo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.marisma.practica3_2024.R
import com.marisma.practica3_2024.catalogo.song
import com.marisma.practica3_2024.catalogo.songProvider

class SongAdapter(
    private val songList: List<song>,
    private val onClickListener: (song) -> Unit,
) : RecyclerView.Adapter<SongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SongViewHolder(layoutInflater.inflate(R.layout.item_song, parent, false))
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val item = songList[position]
        holder.render(item, onClickListener)

        holder.binding.cbFav.isChecked = item.favourite

        holder.binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
            val song = songList.find { it == item }
            song?.favourite = isChecked
            if (isChecked) {
                songProvider.favouriteSongs.add(song!!)
                Toast.makeText(holder.itemView.context, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            } else {
                songProvider.favouriteSongs.remove(song!!)
                Toast.makeText(holder.itemView.context, "Quitado de favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
