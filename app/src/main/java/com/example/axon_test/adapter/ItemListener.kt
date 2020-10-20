package com.example.axon_test.adapter

import com.example.axon_test.adapter.item.UserItem

interface ItemListener {

    fun onUserClick(item: UserItem) {}
}