package ru.alexnimas.network.response

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    var id: Int? = null,
    @SerializedName("logo_path")
    var logoPath: String? = null,
    var name: String? = null,
    @SerializedName("origin_country")
    var originCountry: String? = null
)