package com.example.local.mapper

import com.example.domain.entity.*
import com.example.remote.model.UsersRemote

class UserMapper {

    fun toLocalItems(users: UsersRemote): List<User>? {
        return users.results?.map {
            User(
                gender = it.gender,
                name = mapName(it.name),
                location = mapLocation(it.location),
                email = it.email,
                dob = mapDob(it.dob),
                phone = it.phone,
                cell = it.cell,
                picture = mapPicture(it.picture)
            )
        }
    }

    private fun mapName(name: com.example.remote.model.Name?): Name? {
        return Name(name?.title, name?.first, name?.last)
    }

    private fun mapLocation(location: com.example.remote.model.Location?): Location? {
        return Location(city = location?.city)
    }

    private fun mapDob(dob: com.example.remote.model.Dob?): Dob? {
        return Dob(age = dob?.age, date = dob?.date)
    }

    private fun mapPicture(picture: com.example.remote.model.Picture?): Picture? {
        return Picture(
            large = picture?.large,
            medium = picture?.medium,
            thumbnail = picture?.thumbnail
        )
    }
}