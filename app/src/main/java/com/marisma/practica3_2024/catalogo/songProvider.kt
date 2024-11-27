package com.marisma.practica3_2024.catalogo

import com.marisma.practica3_2024.R

class songProvider {
    companion object {
        val songList = mutableListOf<song>(
            // The Weeknd
            song("1", "Blinding Lights", "The Weeknd", "2019", "After Hours", "Synthwave", R.drawable.blindlights, false),
            song("2", "Save Your Tears", "The Weeknd", "2020", "After Hours", "Synthpop", R.drawable.save_your_tears, false),
            song("3", "Take My Breath", "The Weeknd", "2021", "Dawn FM", "Electronic", R.drawable.take_my_breath, false),

            // Billie Eilish
            song("4", "bad guy", "Billie Eilish", "2019", "When We All Fall Asleep, Where Do We Go?", "Electropop", R.drawable.bad_guy, false),
            song("5", "lovely", "Billie Eilish", "2018", "lovely (with Khalid)", "Indie Pop", R.drawable.lovely, false),
            song("6", "When the Party's Over", "Billie Eilish", "2018", "When We All Fall Asleep, Where Do We Go?", "Pop", R.drawable.when_the_partys_over, false),

            // Yung Beef
            song("7", "Metallica", "Yung Beef", "2020", "El Plugg 2", "Trap", R.drawable.metallica, false),
            song("8", "Pronto Llegará", "Yung Beef", "2020", "El Plugg 2", "Trap", R.drawable.pronto_llegara, false),
            song("9", "Ready pa Morir", "Yung Beef", "2020", "El Plugg 2", "Trap", R.drawable.ready_pa_morir, false)
        )

        val favouriteSongs = mutableListOf<song>(
            // Las canciones favoritas se guardan aquí
        )
    }
}
