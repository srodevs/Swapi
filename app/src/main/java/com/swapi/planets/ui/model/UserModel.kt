package com.swapi.planets.ui.model

import com.swapi.planets.data.database.entity.UserEntity

data class UserModel(
    var name: String,
    var lastnameFather: String,
    var lastnameMother: String,
    var born: String,
    var country: String,
)

fun UserModel.toDomain() = UserEntity(
    name = name,
    lastnameFather = lastnameFather,
    lastnameMother = lastnameMother,
    dateBorn = born,
    country = country
)

fun UserEntity.toDomain() = UserModel(
    name = name,
    lastnameFather = lastnameFather,
    lastnameMother = lastnameMother,
    born = dateBorn,
    country = country
)