package com.ngam.circleimageview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import kotlinx.android.synthetic.main.imageview.view.*
import java.io.File

class CircleImage(context: Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {

    private var loadImages: LoadImages = LoadImages(context)
    private var dimension: Int? = null

    fun strokeColor(@ColorInt color: Int) {
        contentImage.strokeColor = color
    }

    fun strokeWith(@Dimension width: Int) {
        contentImage.strokeWidth = width
    }

    fun background(@ColorInt back: Int) {
        contentImage.setCardBackgroundColor(back)
    }

    fun setImage(url: String?) {
        loadImages.loadUrl(image, url, false)
    }

    fun setImage(drawable: Drawable?) {
        loadImages.loadDrawable(image, drawable, false)
    }

    fun setImage(bitmap: Bitmap?) {
        loadImages.loadBitmap(image, bitmap, false)
    }

    fun setImage(file: File?) {
        loadImages.loadPNG(image, file, false)
    }

    init {

        inflate(context, R.layout.imageview, this)
        /*val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.imageview, this)*/
        val typed = context.obtainStyledAttributes(attributeSet, R.styleable.circleView)
        try {
            val strokecolor = typed.getColor(R.styleable.circleView_stroke_color, -1)
            val strokeWith = typed.getDimensionPixelSize(R.styleable.circleView_stroke_with, -1)
            val images = typed.getDrawable(R.styleable.circleView_image_path)
            val centerCrop = typed.getBoolean(R.styleable.circleView_center_crop, false)
            loadImages.loadDrawable(image, images, centerCrop)
            contentImage.strokeColor = strokecolor
            contentImage.strokeWidth = strokeWith
            dimension?.let {
                contentImage.radius = (it * 1.5).toFloat()
            }

        } catch (e: Throwable) {
            e.printStackTrace()
        }
        typed.recycle()
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        dimension = this.height
    }
}