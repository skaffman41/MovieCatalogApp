package ru.alexnimas.core_api.repo

import io.reactivex.Single
import ru.alexnimas.core_api.dto.Movie

interface Repository {
    fun getPopularMovies(apiKey: String, page: Int): Single<Movie>
}