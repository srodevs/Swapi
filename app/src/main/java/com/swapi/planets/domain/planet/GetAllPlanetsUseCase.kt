package com.swapi.planets.domain.planet

import com.swapi.planets.data.network.PlanetService
import com.swapi.planets.data.network.response.PlanetResponse
import javax.inject.Inject

class GetAllPlanetsUseCase @Inject constructor(
    private val planetService: PlanetService
) {

    suspend fun invoke(): List<PlanetResponse> {
        val res = planetService.getAllPlanets()
        return if (res?.listPlanet?.isNotEmpty() == true) {
            res.listPlanet!!
        } else {
            emptyList()
        }
    }
}