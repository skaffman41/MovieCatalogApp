package ru.alexnimas.details.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse

interface DetailsApi {
    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int?, @Query("api_key") apiKey: String)
            : Single<MovieDetailsResponse>
}