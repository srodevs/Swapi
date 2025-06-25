package com.swapi.planets.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.swapi.planets.data.database.dao.UserDao
import com.swapi.planets.data.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}