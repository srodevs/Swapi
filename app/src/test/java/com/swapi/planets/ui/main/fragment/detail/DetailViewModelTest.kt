package com.swapi.planets.ui.main.fragment.detail

import com.swapi.planets.data.network.response.PlanetResponse
import com.swapi.planets.domain.planet.GetInfoPlanetUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {
    @MockK
    private lateinit var getInfoPlanetUseCase: GetInfoPlanetUseCase

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        viewModel = DetailViewModel(getInfoPlanetUseCase)
    }

    @Test
    fun `getInfoPlanet should call useCase and return planet via callback`() = runTest {
        // given
        val planetId = "5"
        val expectedPlanet = PlanetResponse(name = "Jupiter")

        coEvery { getInfoPlanetUseCase.invoke(planetId) } returns expectedPlanet

        var callbackResult: PlanetResponse? = null

        // when
        viewModel.getInfoPlanet(planetId) {
            callbackResult = it
        }

        // Assert
        coVerify(exactly = 1) { getInfoPlanetUseCase.invoke(planetId) }

        assertEquals(callbackResult, expectedPlanet)
    }

}