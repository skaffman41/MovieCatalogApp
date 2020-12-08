package ru.alexnimas.main.repo

import io.reactivex.Single
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse

interface MainRepository {
    fun getPopularMovies(page: Int): Single<List<Movie>>

    fun getTopRatedMovies(page: Int): Single<List<Movie>>

    fun getNowPlayingMovies(page: Int): Single<List<Movie>>

    fun getOnTheAirShows(page: Int): Single<List<Movie>>
}