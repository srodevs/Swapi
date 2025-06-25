package com.swapi.planets.core

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefs @Inject constructor(@ApplicationContext private val context: Context) {
    private val spName = "prefsConf"
    private val spValueLogin = "login"
    private val storage: SharedPreferences = context.getSharedPreferences(spName, 0)

    fun getValueLogin() = storage.getBoolean(spValueLogin, false)
    fun setValueLogin(valueLogin: Boolean) {
        storage.edit { putBoolean(spValueLogin, valueLogin) }
    }
}