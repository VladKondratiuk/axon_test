package com.example.axon_test.adapter.item

import com.example.domain.entity.User

data class UserItem(val user: User) : BaseItem() {

    override val type: BaseItemEnum
        get() = BaseItemEnum.USER
}