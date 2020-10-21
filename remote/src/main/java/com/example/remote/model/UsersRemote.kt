package com.example.remote.model

import com.google.gson.annotations.SerializedName

data class UsersRemote(
    @SerializedName("results")
    var results: List<User>?
)

data class User(
    @SerializedName("gender")
    var gender: String?,
    @SerializedName("name")
    var name: Name?,
    @SerializedName("location")
    var location: Location?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("dob")
    var dob: Dob?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("cell")
    var cell: String?,
    @SerializedName("picture")
    var picture: Picture?,
)

data class Dob(
    @SerializedName("age")
    var age: Long?
)

data class Location(
//    @SerializedName("street")
//    var street: String?,
    @SerializedName("city")
    var city: String?
)

data class Name(
    @SerializedName("title")
    var title: String?,
    @SerializedName("first")
    var first: String?,
    @SerializedName("last")
    var last: String?
)

data class Picture(
    @SerializedName("large")
    var large: String?,
    @SerializedName("medium")
    var medium: String?,
    @SerializedName("thumbnail")
    var thumbnail: String?
)