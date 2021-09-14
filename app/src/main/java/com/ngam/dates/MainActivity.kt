package com.ngam.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngam.calculatedates.Logic.CompareDates
import com.ngam.calculatedates.Logic.ConvertDate
import com.ngam.calculatedates.Logic.ConvertDate.Companion.addDaysToDate
import com.ngam.calculatedates.Logic.ConvertDate.Companion.convertDate
import com.ngam.calculatedates.data.Result
import com.ngam.zippy.CreateFile
import com.ngam.zippy.Zipper
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileWriter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("APPLYS ${convertDate(null, "MM/dd/yyyy HH:mm:ss")}")
        val fecha = "20/01/2020"
        println("APPLYS ${addDaysToDate(fecha, "dd/MM/yyyy", -20)}")
        boton.setOnClickListener {
            writeFile("sdsd")
        }
        val datemax = CompareDates.plusDate("01/01/1973", 12)
        val mindate = CompareDates.minusDate("01/01/1973", 130)
        val result = CompareDates.rangeDate("01/01/1973", mindate, datemax)
        println("RESULT $datemax | $mindate || $result")
    }


    private fun writeFile(data: String?): File? {
        try {
            if (data.isNullOrEmpty()) {
                return null
            } else {
                val dir = filesDir
                val directory = File(dir, "AQUI")
                if (dir.isDirectory && directory.exists()) {
                    directory.deleteRecursively()
                }
                directory.mkdir()
                CreateFile.apply {
                    rootPath = directory
                }
                val lista: ArrayList<File> = arrayListOf(
                    CreateFile.create("holaaaaa"),
                    CreateFile.create("YAAAAA"),
                    CreateFile.create("SDDJKSKJDHSDD"),
                    CreateFile.create("SDJFSDFDH")
                )
                val fileZip = File(directory, "SINGLEFILE.zip")
                //ZipUtils().zipFile(file.absolutePath, fileZip.absolutePath, "")
                Zipper.zip(CreateFile.create("holaaaaa"), fileZip, "12345")
                lista.forEach {
                    it.delete()
                }
                //Zipper.unzip(fileZip,directory,"MANUEL")
                return fileZip
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            return null
        }
    }
}