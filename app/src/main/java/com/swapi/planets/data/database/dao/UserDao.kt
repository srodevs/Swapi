package com.swapi.planets.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.swapi.planets.data.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query(value = "SELECT * FROM user_table")
    suspend fun getAllUsers(): List<UserEntity>

}