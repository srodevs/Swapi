package com.swapi.planets.data.network

import com.swapi.planets.data.network.model.MainResponse
import com.swapi.planets.data.network.model.PlanetResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiPlanet {

    @GET("/api/planets/")
    suspend fun getListPlanet(): Response<MainResponse>

    @GET("/api/planets/{id}")
    suspend fun getPlanet(
        @Path("id") planetId: String,
    ): Response<PlanetResponse>


}