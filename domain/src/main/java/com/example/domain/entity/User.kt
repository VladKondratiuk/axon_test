package com.example.domain.entity

data class User(
    val gender: String?,
    val name: Name?,
    val location: Location?,
    val email: String?,
    val dob: Dob?,
    val phone: String?,
    val cell: String?,
    val picture: Picture?,
)

data class Dob(
    val age: Long?,
    val date: String?
)

data class Location(
    val city: String?
)

data class Name(
    val title: String?,
    val first: String?,
    val last: String?
)

data class Picture(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
)