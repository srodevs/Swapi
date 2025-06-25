package com.swapi.planets.data.network.model

import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("count") var count: Int?,
    @SerializedName("next") var next: String?,
    @SerializedName("previous") var previous: Any?,
    @SerializedName("results") var listPlanet: List<PlanetResponse>?,
)

data class PlanetResponse(
    @SerializedName("name") var name: String?,
    @SerializedName("rotation_period") var rotationPeriod: String?,
    @SerializedName("orbital_period") var orbitalPeriod: String?,
    @SerializedName("diameter") var diameter: String?,
    @SerializedName("climate") var climate: String?,
    @SerializedName("gravity") var gravity: String?,
    @SerializedName("terrain") var terrain: String?,
    @SerializedName("surface_water") var surfaceWater: String?,
    @SerializedName("population") var population: String?,
    @SerializedName("residents") var listResidents: List<String>?,
    @SerializedName("films") var listFilms: List<String>?,
    @SerializedName("created") var created: String?,
    @SerializedName("edited") var edited: String?,
    @SerializedName("url") var url: String?,
)