package com.swapi.planets.domain.planet

import com.swapi.planets.data.network.PlanetService
import com.swapi.planets.data.network.model.PlanetResponse
import javax.inject.Inject

class GetInfoPlanetUseCase @Inject constructor(
    private val planetService: PlanetService
) {

    suspend fun invoke(planetId: String): PlanetResponse {
        return planetService.getPlanetInfo(planetId) ?: PlanetResponse(
            name = "No Disponible"
        )
    }
}