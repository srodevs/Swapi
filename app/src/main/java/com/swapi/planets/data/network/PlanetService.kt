package com.swapi.planets.data.network

import android.util.Log
import com.swapi.planets.data.network.response.MainResponse
import com.swapi.planets.data.network.response.PlanetResponse
import java.net.SocketTimeoutException
import javax.inject.Inject

class PlanetService @Inject constructor(
    private val apiClient: ApiPlanet
) {

    companion object {
        private const val TAG = "PlanetService"
    }

    suspend fun getAllPlanets(): MainResponse? {
        return try {
            val response = apiClient.getListPlanet()
            if (response.isSuccessful && response.body() != null) {
                Log.e(TAG, "response del planets: " + response.body().toString())
                response.body()
            } else {
                null
            }
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, e.message.toString())
            null
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            null
        }
    }

    suspend fun getPlanetInfo(planetId: String): PlanetResponse? {
        return try {
            val response = apiClient.getPlanet(planetId)
            if (response.isSuccessful && response.body() != null) {
                Log.e(TAG, "response del planets: " + response.body().toString())
                response.body()
            } else {
                null
            }
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, e.message.toString())
            null
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
            null
        }
    }

}