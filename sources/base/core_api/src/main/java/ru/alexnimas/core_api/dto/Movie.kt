package ru.alexnimas.core_api.dto

data class Movie(
    val id: Int?,
    val posterPath: String?,
    val originalName: String?,
    val title: String?
) {
    val imageUrl: String
        get() = "https://image.tmdb.org/t/p/w300${posterPath}"

    val movieTitle: String
        get() = title ?: originalName ?: ""
}