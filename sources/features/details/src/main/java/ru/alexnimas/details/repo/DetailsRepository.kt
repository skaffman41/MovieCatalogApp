package ru.alexnimas.details.repo

import io.reactivex.Single
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse


interface DetailsRepository {
    fun getMovieDetails(movieId: Int?): Single<MovieDetailsResponse>
}