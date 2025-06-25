package com.swapi.planets.data.network.model

import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("count") var count: Int?,
    @SerializedName("next") var next: String?,
    @SerializedName("previous") var previous: Any?,
    @SerializedName("results") var listPlanet: List<PlanetResponse>?,
)

data class PlanetResponse(
    @SerializedName("name") var name: String? = null,
    @SerializedName("rotation_period") var rotationPeriod: String? = null,
    @SerializedName("orbital_period") var orbitalPeriod: String? = null,
    @SerializedName("diameter") var diameter: String? = null,
    @SerializedName("climate") var climate: String? = null,
    @SerializedName("gravity") var gravity: String? = null,
    @SerializedName("terrain") var terrain: String? = null,
    @SerializedName("surface_water") var surfaceWater: String? = null,
    @SerializedName("population") var population: String? = null,
    @SerializedName("residents") var listResidents: List<String>? = null,
    @SerializedName("films") var listFilms: List<String>? = null,
    @SerializedName("created") var created: String? = null,
    @SerializedName("edited") var edited: String? = null,
    @SerializedName("url") var url: String? = null,
)