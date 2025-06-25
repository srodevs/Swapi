package com.swapi.planets.data

import com.swapi.planets.data.database.dao.UserDao
import com.swapi.planets.data.database.entity.UserEntity
import com.swapi.planets.ui.model.UserModel
import com.swapi.planets.ui.model.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getAllUser(): List<UserModel> {
        return userDao.getAllUsers().map { it.toDomain() }
    }
}