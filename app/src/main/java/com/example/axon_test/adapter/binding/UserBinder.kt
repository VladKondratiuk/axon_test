package com.example.axon_test.adapter.binding

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.example.axon_test.R
import com.example.domain.entity.User
import com.example.domain.entity.UserImageEnum
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.item_user.view.ivImage
import kotlinx.android.synthetic.main.item_user.view.tvUsername

object UserBinder {

    fun bindImage(view: View, user: User, size: UserImageEnum) {
        val url = when (size) {
            UserImageEnum.LARGE -> user.picture?.large
            UserImageEnum.MEDIUM -> user.picture?.medium
            UserImageEnum.THUMBNAIL -> user.picture?.thumbnail
        }
        Glide.with(view.context)
            .load(GlideUrl(url))
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

    fun bindProfileUser(view: View, user: User) {
        bindImage(view, user, UserImageEnum.LARGE)
        bindName(view, user)
        view.tvAge.text =
            view.context.getString(R.string.string_user_age, user.dob?.age?.toString())
        view.tvCellPhone.text = user.cell
        view.tvEmail.text = user.email
        view.tvPhone.text = user.phone
        view.tvLocation.text = user.location?.city
        view.tvGender.text = user.gender
    }
}