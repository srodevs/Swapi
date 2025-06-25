package com.swapi.planets.domain

import com.swapi.planets.core.SharedPrefs
import javax.inject.Inject

class ValidateLoginUseCase @Inject constructor(
    private val sharedPrefs: SharedPrefs
) {

    fun invoke() = sharedPrefs.getValueLogin()
}