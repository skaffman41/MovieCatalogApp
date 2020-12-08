package ru.alexnimas.details.data.remote

import io.reactivex.Single
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse

interface DetailsRemoteDataSource {
    fun getMovieDetails(movieId: Int?): Single<MovieDetailsResponse>
}