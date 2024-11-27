package com.marisma.practica3_2024.catalogo.itemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.marisma.practica3_2024.R
import com.marisma.practica3_2024.catalogo.songProvider
import com.marisma.practica3_2024.databinding.FragmentDetailItemBinding
import com.marisma.practica3_2024.catalogo.song

class DetailItemFragment : Fragment() {
    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    private val args: DetailItemFragmentArgs by navArgs()

    private var song: song? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_item_list_title)

        rellenarDetalles(args.songId)

        binding.tvDetailItemListTittle.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvTitulo1.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvCoinCountry.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvTitulo2.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvCoinValue.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvTitulo3.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvCoinYear.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
    }

    private fun rellenarDetalles(songId: String) {
        // Encuentra la canción en la lista de canciones
        song = songProvider.songList.find { it.id == songId }

        if (song == null) {
            Toast.makeText(context, "La canción no se encontró", Toast.LENGTH_SHORT).show()
            return
        }

        // Si la canción existe, llena los campos de texto y la imagen con los datos de la canción
        song?.let {
            Glide.with(this)
                .load(it.imagen)
                .into(binding.ivImagen)
            binding.tvCoinCountry.text = it.titulo
            binding.tvCoinValue.text = it.artista
            binding.tvCoinYear.text = it.anno
            binding.tvDetailItemListTittle.text = it.detalles
            binding.cbFav.isChecked = it.favourite

            binding.cbFav.setOnCheckedChangeListener { _, isChecked ->
                it.favourite = isChecked

                if (isChecked) {
                    songProvider.favouriteSongs.add(it)
                    Toast.makeText(this.context, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
                } else {
                    songProvider.favouriteSongs.remove(it)
                    Toast.makeText(this.context, "Quitado de favoritos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
