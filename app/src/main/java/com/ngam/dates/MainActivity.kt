package com.ngam.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngam.calculatedates.Logic.ConvertDate.Companion.addDaysToDate
import com.ngam.calculatedates.Logic.ConvertDate.Companion.convertDate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("APPLYS ${convertDate(null, "MM/dd/yyyy HH:mm:ss")}")
        val fecha = "20/01/2020"
        println("APPLYS ${addDaysToDate(fecha, "dd/MM/yyyy", -20)}")
    }
}