package com.ngam.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ngam.calculatedates.Logic.CompareDates
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
                val fileZip = File(directory, "NNUEVO.zip")
                //ZipUtils().zipFile(file.absolutePath, fileZip.absolutePath, "")
                Zipper.zip(lista, fileZip, "MANUEL")
                lista.forEach {
                    it.delete()
                }
                Zipper.unzip(fileZip,directory,"MANUEL")
                return fileZip
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            return null
        }
    }
}