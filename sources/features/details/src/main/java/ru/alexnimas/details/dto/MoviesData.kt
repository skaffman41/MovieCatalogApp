package ru.alexnimas.details.dto

import ru.alexnimas.core_api.dto.Movie

class MoviesData(
    val nowPlayingMovies: List<Movie>,
    val onTheAirShows: List<Movie>,
    val popularMovies: List<Movie>,
    val topRatedMovies: List<Movie>,
)