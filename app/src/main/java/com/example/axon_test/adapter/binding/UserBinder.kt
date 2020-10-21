package com.example.axon_test.adapter.binding

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.example.axon_test.R
import com.example.domain.entity.User
import kotlinx.android.synthetic.main.item_user.view.*

object UserBinder {

    fun bindImage(view: View, user: User) {
        Glide.with(view.context)
            .load(GlideUrl(user.picture?.medium))
            .apply(RequestOptions.circleCropTransform())
            .apply(RequestOptions.placeholderOf(R.drawable.ic_user))
            .apply(RequestOptions.errorOf(R.drawable.ic_user))
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
            .into(view.ivImage)
    }

    fun bindName(view: View, user: User) {
        val username =
            view.context.getString(R.string.string_user_name, user.name?.first, user.name?.last)
        view.tvUsername.text = username
    }
}