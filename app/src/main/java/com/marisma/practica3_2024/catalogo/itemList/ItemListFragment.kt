package com.marisma.practica3_2024.catalogo.itemList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marisma.practica3_2024.R
import com.marisma.practica3_2024.catalogo.adapter.SongAdapter
import com.marisma.practica3_2024.catalogo.song
import com.marisma.practica3_2024.catalogo.songProvider
import com.marisma.practica3_2024.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_label)

        iniciarRecyclerViewVert()

        binding.tvItemListTittle.typeface = ResourcesCompat.getFont(requireContext(), R.font.momentz)
    }

    fun iniciarRecyclerViewVert() {
        val manager = LinearLayoutManager(requireContext())
        binding.RVCoins.layoutManager = manager
        binding.RVCoins.adapter = SongAdapter(
            songProvider.songList,
            { song -> onItemSelected(song) },
        )
    }

    private fun onItemSelected(coins: song) {
        val action = ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment(coins.id)
        findNavController().navigate(action)
    }
}