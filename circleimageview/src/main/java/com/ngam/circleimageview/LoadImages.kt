package com.ngam.circleimageview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

class LoadImages(val context: Context) {

    fun loadDrawable(imageView: ImageView, drawable: Drawable?, centercrop: Boolean) {
        println("CENTER CROP $centercrop")
        if (centercrop) {
            Glide.with(context)
                .asDrawable()
                .centerCrop()
                .load(drawable)
                .into(imageView)
        } else {
            Glide.with(context)
                .asDrawable()
                .load(drawable)
                .into(imageView)
        }

    }

    fun loadPNG(imageView: ImageView, drawable: File?, centercrop: Boolean) {
        if (centercrop) {
            Glide.with(context)
                .load(drawable)
                .centerCrop()
                .into(imageView)
        } else {
            Glide.with(context)
                .load(drawable)
                .into(imageView)
        }
    }

    fun loadUrl(imageView: ImageView, drawable: String?, centercrop: Boolean) {
        if (centercrop) {
            Glide.with(context)
                .load(drawable)
                .centerCrop()
                .into(imageView)
        } else {
            Glide.with(context)
                .load(drawable)
                .into(imageView)
        }
    }

    fun loadBitmap(imageView: ImageView, drawable: Bitmap?, centercrop: Boolean) {
        if (centercrop) {
            Glide.with(context)
                .asBitmap()
                .centerCrop()
                .load(drawable)
                .into(imageView)
        } else {
            Glide.with(context)
                .asBitmap()
                .load(drawable)
                .into(imageView)
        }
    }
}