package ru.alexnimas.main.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.alexnimas.core_api.dto.response.GeneralPopularMoviesResponse
import ru.alexnimas.core_api.dto.response.MovieDetailsResponse

interface MainApi {
    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String, @Query("page") page: Int)
            : Single<GeneralPopularMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String, @Query("page") page: Int)
            : Single<GeneralPopularMoviesResponse>

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String, @Query("page") page: Int)
            : Single<GeneralPopularMoviesResponse>

    @GET("tv/on_the_air")
    fun getOnTheAirShows(@Query("api_key") apiKey: String, @Query("page") page: Int)
            : Single<GeneralPopularMoviesResponse>
}