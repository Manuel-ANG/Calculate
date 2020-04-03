package com.ngam.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contenido.apply {
            strokeWith(3)
            strokeColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_green_dark))
            //setImage(ContextCompat.getDrawable(this@MainActivity, R.drawable.abc))
            background(ContextCompat.getColor(this@MainActivity, android.R.color.holo_red_dark))
        }
    }
}