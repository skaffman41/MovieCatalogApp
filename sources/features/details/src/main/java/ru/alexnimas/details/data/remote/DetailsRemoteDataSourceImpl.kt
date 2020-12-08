package ru.alexnimas.details.data.remote

import io.reactivex.Single
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse
import ru.alexnimas.details.BuildConfig
import javax.inject.Inject

class DetailsRemoteDataSourceImpl @Inject constructor(
    private val api: DetailsApi
) : DetailsRemoteDataSource {
    override fun getMovieDetails(movieId: Int?): Single<MovieDetailsResponse> {
        return api.getMovieDetails(movieId, BuildConfig.TMDB_API_KEY)
    }
}