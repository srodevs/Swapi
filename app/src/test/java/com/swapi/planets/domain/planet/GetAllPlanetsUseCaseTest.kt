package com.swapi.planets.domain.planet

import com.swapi.planets.data.network.PlanetService
import com.swapi.planets.data.network.response.PlanetResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllPlanetsUseCaseTest {

    @RelaxedMockK
    private lateinit var planetService: PlanetService

    private lateinit var getAllPlanetsUseCase: GetAllPlanetsUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)

        getAllPlanetsUseCase = GetAllPlanetsUseCase(planetService)
    }

    @Test
    fun `get all planets is null or empty return empty`() = runBlocking {
        val listPlanet: List<PlanetResponse> = listOf(
            PlanetResponse(name = "Tatooine", population = "200000"),
            PlanetResponse(name = "Alderaan", population = "2000000000")
        )

        coEvery {
            planetService.getAllPlanets()?.listPlanet
        } returns listPlanet

        val res = getAllPlanetsUseCase.invoke()

        assert(res.isNotEmpty())
        assert(res.size > 1)
        assert(!res[0].name.isNullOrEmpty())
    }

}