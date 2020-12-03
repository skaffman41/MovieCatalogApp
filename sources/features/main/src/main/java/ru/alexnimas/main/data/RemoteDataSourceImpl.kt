package ru.alexnimas.main.data

import io.reactivex.Observable
import io.reactivex.Single
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.core_api.dto.response.GeneralPopularMoviesResponse
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse
import ru.alexnimas.main.BuildConfig
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: Api
) : RemoteDataSource {
    override fun getPopularMovies(page: Int): Single<List<Movie>> {
        return api.getPopularMovies(BuildConfig.TMDB_API_KEY, 1)
            .map {
                it.results.map { movieResponse ->
                    Movie(movieResponse.posterPath, movieResponse.originalName, movieResponse.title)
                }
            }
    }

    override fun getTopRatedMovies(page: Int): Single<List<Movie>> {
        return api.getTopRatedMovies(BuildConfig.TMDB_API_KEY, 1)
            .map {
                it.results.map { movieResponse ->
                    Movie(movieResponse.posterPath, movieResponse.originalName, movieResponse.title)
                }
            }
    }

    override fun getNowPlayingMovies(page: Int): Single<List<Movie>> {
        return api.getNowPlayingMovies(BuildConfig.TMDB_API_KEY, page)
            .map {
                it.results.map { movieResponse ->
                    Movie(movieResponse.posterPath, movieResponse.originalName, movieResponse.title)
                }
            }
    }

    override fun getOnTheAirShows(page: Int): Single<List<Movie>> {
        return api.getOnTheAirShows(BuildConfig.TMDB_API_KEY, 1)
            .map {
                it.results.map { movieResponse ->
                    Movie(movieResponse.posterPath, movieResponse.originalName, movieResponse.title)
                }
            }
    }

    override fun getMovieDetails(movieId: Int?): Single<MovieDetailsResponse> {
        return api.getMovieDetails(movieId, BuildConfig.TMDB_API_KEY)
    }
}