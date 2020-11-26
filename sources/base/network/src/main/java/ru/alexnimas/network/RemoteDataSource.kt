package ru.alexnimas.network

import io.reactivex.Observable
import io.reactivex.Single
import ru.alexnimas.network.response.GeneralPopularMoviesResponse
import ru.alexnimas.network.response.MovieDetailsResponse

interface RemoteDataSource {
    fun getPopularMovies(page: Int): Single<GeneralPopularMoviesResponse>

    fun getTopRatedMovies(page: Int): Single<GeneralPopularMoviesResponse>

    fun getNowPlayingMovies(page: Int): Observable<GeneralPopularMoviesResponse>

    fun getOnTheAirShows(page: Int): Single<GeneralPopularMoviesResponse>

    fun getMovieDetails(movieId: Int?): Single<MovieDetailsResponse>
}