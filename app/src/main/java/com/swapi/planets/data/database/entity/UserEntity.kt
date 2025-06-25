package com.swapi.planets.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "last_name_father") val lastnameFather: String,
    @ColumnInfo(name = "last_name_mother") val lastnameMother: String,
    @ColumnInfo(name = "date_born") val dateBorn: String,
    @ColumnInfo(name = "country") val country: String,
)