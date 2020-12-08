package ru.alexnimas.main.data.remote

import io.reactivex.Single
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse
import ru.alexnimas.main.BuildConfig
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(
    private val api: MainApi
) : MainRemoteDataSource {
    override fun getPopularMovies(page: Int): Single<List<Movie>> {
        return api.getPopularMovies(BuildConfig.TMDB_API_KEY, 1)
            .map {
                it.results.map { movieResponse ->
                    Movie(
                        movieResponse.id,
                        movieResponse.posterPath,
                        movieResponse.originalName,
                        movieResponse.title
                    )
                }
            }
    }

    override fun getTopRatedMovies(page: Int): Single<List<Movie>> {
        return api.getTopRatedMovies(BuildConfig.TMDB_API_KEY, 1)
            .map {
                it.results.map { movieResponse ->
                    Movie(
                        movieResponse.id,
                        movieResponse.posterPath,
                        movieResponse.originalName,
                        movieResponse.title
                    )
                }
            }
    }

    override fun getNowPlayingMovies(page: Int): Single<List<Movie>> {
        return api.getNowPlayingMovies(BuildConfig.TMDB_API_KEY, page)
            .map {
                it.results.map { movieResponse ->
                    Movie(
                        movieResponse.id,
                        movieResponse.posterPath,
                        movieResponse.originalName,
                        movieResponse.title
                    )
                }
            }
    }

    override fun getOnTheAirShows(page: Int): Single<List<Movie>> {
        return api.getOnTheAirShows(BuildConfig.TMDB_API_KEY, 1)
            .map {
                it.results.map { movieResponse ->
                    Movie(
                        movieResponse.id,
                        movieResponse.posterPath,
                        movieResponse.originalName,
                        movieResponse.title
                    )
                }
            }
    }
}