package com.marisma.practica3_2024.catalogo.favItemList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.marisma.practica3_2024.catalogo.song
import com.marisma.practica3_2024.catalogo.songProvider
import com.marisma.practica3_2024.databinding.FragmentFavDetailItemBinding
import com.marisma.practica3_2024.R

class FavDetailItemFragment : Fragment() {

    private var _binding: FragmentFavDetailItemBinding? = null
    private val binding get() = _binding!!

    private val args: FavDetailItemFragmentArgs by navArgs()

    private var song: song? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.detail_item_list_title)

        rellenarDetalles(args.SongId)

        val fabComment = binding.fabComment
        fabComment.setOnClickListener {
            showCommentDialog()
        }

        binding.tvDetailSeriesTitle.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvCountryTitle.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvSeriesCountry.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvValueTitle.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvSeriesValue.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvYearTitle.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvSeriesYear.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvDetailsTitle.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
        binding.tvSeriesDetails.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
    }

    private fun rellenarDetalles(songId: String) {
        // Encuentra la canción en la lista de canciones
        song = songProvider.songList.find { it.id == songId }

        // Si la canción existe, llena los campos de texto y la imagen con los datos de la canción
        song?.let {
            Glide.with(this)
                .load(it.imagen)
                .into(binding.ivSeriesImage)
            binding.tvSeriesCountry.text = it.titulo
            binding.tvSeriesValue.text = it.artista
            binding.tvSeriesYear.text = it.anno
            binding.tvSeriesDetails.text = it.detalles
            binding.cbSeriesFav.isChecked = it.favourite

            binding.cbSeriesFav.setOnCheckedChangeListener { _, isChecked ->
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

    private fun showCommentDialog() {
        // Crear un EditText
        val input = EditText(context)

        if (song?.comentarios.isNullOrEmpty()) {
            input.hint = "Introduce un comentario"
        } else {
            input.setText(song?.comentarios)
        }

        // Crear un AlertDialog
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Comentario")
            .setView(input)
            .setPositiveButton("Guardar") { dialog, _ ->
                val comment = input.text.toString()
                song?.comentarios = comment

                Toast.makeText(context, comment, Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }
            .create()

        dialog.show()
    }
}
