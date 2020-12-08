package ru.alexnimas.details.repo

import io.reactivex.Single
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse
import ru.alexnimas.details.data.remote.DetailsRemoteDataSource
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: DetailsRemoteDataSource
) : DetailsRepository {
    override fun getMovieDetails(movieId: Int?): Single<MovieDetailsResponse> {
        return remoteDataSource.getMovieDetails(movieId)
    }
}