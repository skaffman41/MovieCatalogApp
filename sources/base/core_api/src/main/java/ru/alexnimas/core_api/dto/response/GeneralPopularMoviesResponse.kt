package ru.alexnimas.core_api.dto.response

import com.google.gson.annotations.SerializedName

data class GeneralPopularMoviesResponse(
    val page: Int?,
    @SerializedName("total_results") val totalResults: Int?,
    @SerializedName("total_pages") val totalPages: Int?,
    val results: List<MovieResponse>
)