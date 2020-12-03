package ru.alexnimas.core_api.dto.response

import com.google.gson.annotations.SerializedName
import ru.alexnimas.core_api.dto.response.ProductionCompany

data class MovieDetailsResponse (
    var adult: Boolean? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    var budget: Int? = null,
    var genres: List<GenreResponse>? = null,
    var homepage: String? = null,
    var id: Int? = null,
    @SerializedName("imdb_id")
    var imdbId: String? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompany>? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var status: String? = null,
    var tagline: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Int? = null
)