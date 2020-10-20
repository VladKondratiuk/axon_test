package com.example.axon_test.adapter.binding

import android.view.View
import com.example.domain.entity.User
import kotlinx.android.synthetic.main.item_user.view.*

object UserBinder {

    fun bindName(view: View, user: User) {
        view.tvName.text = user.name
    }
}