package com.ngam.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ngam.calculatedates.Logic.CalculateDate
import com.ngam.calculatedates.Logic.ConvertDate
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dale.setOnClickListener {
            println("EDADES 2016-02-18 ${CalculateDate.calculateLargeDate("18/02/2016", null)}")
            println("EDADES 2018-01-04 ${CalculateDate.calculateLargeDate("04/01/2018", null)}")
            println("EDADES 2018-01-05 ${CalculateDate.calculateLargeDate("05/01/2018", null)}")
            println("EDADES 2019-11-04 ${CalculateDate.calculateLargeDate("04/11/2019", null)}")
            println("EDADES 2019-09-02 ${CalculateDate.calculateLargeDate("02/09/2019", null)}")
        }
    }
}