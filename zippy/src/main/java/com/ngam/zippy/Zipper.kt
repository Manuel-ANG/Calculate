package com.ngam.zippy

import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.model.ZipParameters
import net.lingala.zip4j.model.enums.AesKeyStrength
import net.lingala.zip4j.model.enums.CompressionLevel
import net.lingala.zip4j.model.enums.CompressionMethod
import net.lingala.zip4j.model.enums.EncryptionMethod
import java.io.File

class Zipper {
    companion object {

        fun zip(file: File, destination: File, pwd: String?) {
            val pass = pwd ?: ""
            val parameters = ZipParameters().apply {
                compressionMethod = CompressionMethod.DEFLATE
                compressionLevel = CompressionLevel.ULTRA
            }

            if (pwd != null) {
                parameters.apply {
                    isEncryptFiles = true
                    encryptionMethod = EncryptionMethod.AES
                    aesKeyStrength = AesKeyStrength.KEY_STRENGTH_256
                }
            }
            println("PASSWORD $pass |${pass.isEmpty()}|")
            val zipfile = ZipFile(destination, pass.toCharArray())
            zipfile.addFile(file, parameters)
        }

        fun zip(file: List<File>, destination: File, pwd: String?) {
            val pass = pwd ?: ""
            val parameters = ZipParameters().apply {
                compressionMethod = CompressionMethod.DEFLATE
                compressionLevel = CompressionLevel.ULTRA
            }

            if (pwd != null) {
                parameters.apply {
                    isEncryptFiles = true
                    encryptionMethod = EncryptionMethod.AES
                    aesKeyStrength = AesKeyStrength.KEY_STRENGTH_256
                }
            }
            println("PASSWORD $pass |${pass.isEmpty()}|")
            val destino = "${destination.absolutePath}.zip"
            val zipfile = ZipFile(destino, pass.toCharArray())
            zipfile.addFiles(file, parameters)
        }

        fun unzip(fileLocation: File, fileDestination: File, pwd: String?) {
            val zip = ZipFile("${fileLocation.absolutePath}.zip")
            if (zip.isEncrypted) {
                val pass = pwd ?: ""
                zip.setPassword(pass.toCharArray())
            }
            zip.extractAll(fileDestination.absolutePath)
        }
    }
}