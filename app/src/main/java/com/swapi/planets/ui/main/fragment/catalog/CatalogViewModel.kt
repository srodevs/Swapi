package com.swapi.planets.ui.main.fragment.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.planets.data.network.response.PlanetResponse
import com.swapi.planets.domain.planet.GetAllPlanetsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getAllPlanetsUseCase: GetAllPlanetsUseCase
) : ViewModel() {

    sealed class UiSateCatalog {
        data object Loading : UiSateCatalog()
        data class Success(val listPlanet: List<PlanetResponse>) : UiSateCatalog()
    }

    private val _state = MutableStateFlow<UiSateCatalog>(UiSateCatalog.Loading)
    val state = _state.asStateFlow()

    fun getListPlanet() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = getAllPlanetsUseCase.invoke()
            _state.value = UiSateCatalog.Success(res)
        }
    }
}