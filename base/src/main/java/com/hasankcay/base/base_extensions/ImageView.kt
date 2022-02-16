package com.hasankcay.base.base_extensions

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.squareup.picasso.Picasso

fun ImageView.downloadImage(url: String, context: Context) {
    Picasso.get().load(url).placeholder(doPlaceHolder(context))
        .into(this)
}

fun doPlaceHolder(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 4f
        centerRadius = 20f
        start()
    }
}