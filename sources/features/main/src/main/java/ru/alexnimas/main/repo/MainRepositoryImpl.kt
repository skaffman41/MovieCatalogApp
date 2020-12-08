package ru.alexnimas.main.repo

import io.reactivex.Single
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse
import ru.alexnimas.main.data.remote.MainRemoteDataSource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor (
    private val remoteDataSource: MainRemoteDataSource
) : MainRepository {
    override fun getPopularMovies(page: Int): Single<List<Movie>> {
        return remoteDataSource.getPopularMovies(page)
    }

    override fun getTopRatedMovies(page: Int): Single<List<Movie>> {
        return remoteDataSource.getTopRatedMovies(page)
    }

    override fun getNowPlayingMovies(page: Int): Single<List<Movie>> {
        return remoteDataSource.getNowPlayingMovies(page)
    }

    override fun getOnTheAirShows(page: Int): Single<List<Movie>> {
        return remoteDataSource.getOnTheAirShows(page)
    }
}