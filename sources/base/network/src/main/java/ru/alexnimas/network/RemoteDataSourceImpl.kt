package ru.alexnimas.network

import io.reactivex.Observable
import io.reactivex.Single
import ru.alexnimas.network.response.GeneralPopularMoviesResponse
import ru.alexnimas.network.response.MovieDetailsResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: Api
) : RemoteDataSource {
    override fun getPopularMovies(page: Int): Single<GeneralPopularMoviesResponse> {
        return api.getPopularMovies(BuildConfig.TMDB_API_KEY, 1)
    }

    override fun getTopRatedMovies(page: Int): Single<GeneralPopularMoviesResponse> {
        return api.getTopRatedMovies(BuildConfig.TMDB_API_KEY, 1)
    }

    override fun getNowPlayingMovies(page: Int): Observable<GeneralPopularMoviesResponse> {
        return api.getNowPlayingMovies(BuildConfig.TMDB_API_KEY, page)
    }

    override fun getOnTheAirShows(page: Int): Single<GeneralPopularMoviesResponse> {
        return api.getOnTheAirShows(BuildConfig.TMDB_API_KEY, 1)
    }

    override fun getMovieDetails(movieId: Int?): Single<MovieDetailsResponse> {
        return api.getMovieDetails(movieId, BuildConfig.TMDB_API_KEY)
    }
}