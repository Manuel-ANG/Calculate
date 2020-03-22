package com.ngam.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ngam.calculatedates.Logic.CalculateDate
import com.ngam.calculatedates.Logic.ConvertDate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dale.setOnClickListener {
            println("VALUE ${ConvertDate.toDate("2018-11-09",null)}")
        }
    }
}