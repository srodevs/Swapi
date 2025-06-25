package com.swapi.planets.domain

import android.util.Log
import com.swapi.planets.data.UserRepository
import com.swapi.planets.ui.model.UserModel
import com.swapi.planets.ui.model.toDomain
import javax.inject.Inject

class CreateNewUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend fun invoke(userModel: UserModel) {
        repository.insertUser(userModel.toDomain())
        val user = repository.getAllUser()
        Log.d("CreateNewUserUseCase", "los users son\n$user")
    }

}