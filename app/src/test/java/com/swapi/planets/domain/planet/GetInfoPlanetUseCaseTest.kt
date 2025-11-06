package com.swapi.planets.domain.planet

import com.swapi.planets.data.network.PlanetService
import com.swapi.planets.data.network.response.PlanetResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetInfoPlanetUseCaseTest {

    @RelaxedMockK
    private lateinit var planetService: PlanetService

    private lateinit var getInfoPlanetUseCase: GetInfoPlanetUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)

        getInfoPlanetUseCase = GetInfoPlanetUseCase(planetService)
    }

    @Test
    fun `get all info of planet from id`() = runBlocking {
        val planetId = "1"
        val listPlanet = PlanetResponse(name = "Tatooine", population = "200000")
        coEvery {
            planetService.getPlanetInfo(planetId)
        } returns listPlanet

        val res = getInfoPlanetUseCase.invoke(planetId)

        assert(!res.name.isNullOrEmpty())
    }

}