package ru.alexnimas.main.data.remote

import io.reactivex.Single
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.core_api.dto.response.GeneralPopularMoviesResponse
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse

interface MainRemoteDataSource {
    fun getPopularMovies(page: Int): Single<List<Movie>>

    fun getTopRatedMovies(page: Int): Single<List<Movie>>

    fun getNowPlayingMovies(page: Int): Single<List<Movie>>

    fun getOnTheAirShows(page: Int): Single<List<Movie>>
}