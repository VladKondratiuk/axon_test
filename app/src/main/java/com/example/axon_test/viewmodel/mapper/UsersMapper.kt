package com.example.axon_test.viewmodel.mapper

import com.example.axon_test.adapter.item.UserItem
import com.example.domain.entity.User

class UsersMapper {

    fun toItems(users: List<User>): List<UserItem> {
        return users.map { UserItem(it) }
    }
}