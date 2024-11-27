package com.marisma.practica3_2024.catalogo

data class song(
    val id: String,
    val artista: String,
    val titulo: String,
    val anno: String,
    val detalles: String,
    var comentarios: String,
    val imagen: Int,
    var favourite: Boolean
)