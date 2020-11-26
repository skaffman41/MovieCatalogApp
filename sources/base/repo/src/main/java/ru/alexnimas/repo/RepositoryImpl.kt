package ru.alexnimas.repo

import io.reactivex.Single
import ru.alexnimas.core_api.dto.Movie
import ru.alexnimas.core_api.repo.Repository
import ru.alexnimas.network.RemoteDataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {
    override fun getPopularMovies(apiKey: String, page: Int): Single<Movie> {
        return remoteDataSource.getPopularMovies(1)
            .map { Movie(it.results.firstOrNull()?.originalName ?: "random name") }
    }
}