package ru.alexnimas.network.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("vote_count") var voteCount: Int? = null,
    @SerializedName("poster_path") var posterPath: String? = null,
    @SerializedName("backdrop_path") var backdropPath: String? = null,
    @SerializedName("original_language") var originalLanguage: String? = null,
    @SerializedName("original_title") var originalTitle: String? = null,
    @SerializedName("original_name") var originalName: String? = null,
    @SerializedName("vote_average") var voteAverage: Double? = null,
    @SerializedName("release_date") var releaseDate: String? = null,
    var popularity: Double? = null,
    var video: Boolean? = null,
    var adult: Boolean? = null,
    var title: String? = null,
    var overview: String? = null,
    var movieNowPlaying: Boolean = false,
    var tvOnAir: Boolean = false,
    var popular: Boolean = false
)