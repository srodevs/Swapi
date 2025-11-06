package com.swapi.planets.ui.main.fragment.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.planets.data.network.response.PlanetResponse
import com.swapi.planets.domain.planet.GetInfoPlanetUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getInfoPlanetUseCase: GetInfoPlanetUseCase
) : ViewModel() {

    fun getInfoPlanet(extractIdFromUrl: String, planeInfo: (PlanetResponse) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = getInfoPlanetUseCase.invoke(extractIdFromUrl)
            planeInfo(res)
        }
    }
}