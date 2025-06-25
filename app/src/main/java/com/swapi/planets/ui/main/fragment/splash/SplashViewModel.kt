package com.swapi.planets.ui.main.fragment.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.planets.domain.ValidateLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val validateLoginUseCase: ValidateLoginUseCase
) : ViewModel() {

    fun validateLogin(response: (Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = validateLoginUseCase.invoke()
            delay(5000)
            response(res)
        }
    }
}