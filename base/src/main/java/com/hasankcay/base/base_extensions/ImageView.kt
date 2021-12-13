package com.hasankcay.base.base_extensions

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.hasankcay.base.R
import com.squareup.picasso.Picasso

fun ImageView.downloadImage(url: String, context: Context) {
    Picasso.get().load(url).placeholder(doPlaceHolder(context)).error(R.drawable.ic_empty_dracula)
        .into(this)
}

fun doPlaceHolder(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 4f
        centerRadius = 20f
        start()
    }
}