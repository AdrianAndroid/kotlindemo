package tool

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

fun main() {
    val sourceDir = "/Users/apus/FlutterProjects"
    traverseFolders(sourceDir)
}

fun test() {
    val sourceFolderPath = "/path/to/source/folder"
    val zipFilePath = "/path/to/destination/archive.zip"

    zipFolder(sourceFolderPath, zipFilePath)
    println("文件夹已成功压缩到 $zipFilePath")
}

/**
 * 遍历所有文件夹
 */
fun traverseFolders(folderPath: String) {
    val folder = File(folderPath)
    if (folder.isDirectory) {
        val subFolders = folder.listFiles { file -> file.isDirectory }
        subFolders?.forEach { subFolder ->
            println(subFolder.absolutePath)
            val filePath = subFolder.absolutePath
            val zipFile = "${filePath}.zip"
            zipFolder(filePath, zipFile)
            //traverseFolders(subFolder.absolutePath)
        }
    }
}

fun zipFolder(sourceFolderPath: String, zipFilePath: String) {
    val file = File(zipFilePath)
    if (file.exists()) {
        file.createNewFile()
        setFilePermissions(zipFilePath, "755")
    }

    val sourceFolder = File(sourceFolderPath)
    val outputStream = FileOutputStream(zipFilePath)
    val zipOutputStream = ZipOutputStream(outputStream)


    addFolderToZip(sourceFolder, zipOutputStream, "")

    zipOutputStream.close()
    outputStream.close()
}

private fun addFolderToZip(folder: File, zipOutputStream: ZipOutputStream, parentFolderPath: String) {
    val files = folder.listFiles()
    val buffer = ByteArray(1024)

    files?.forEach { file ->
        if (file.isDirectory) {
            val filePath = if (parentFolderPath.isNotEmpty()) "$parentFolderPath/${file.name}" else file.name
            addFolderToZip(file, zipOutputStream, filePath)
            return@forEach
        }

        val fileInputStream = FileInputStream(file)
        val entry = ZipEntry(if (parentFolderPath.isNotEmpty()) "$parentFolderPath/${file.name}" else file.name)
        zipOutputStream.putNextEntry(entry)

        var length: Int
        while (fileInputStream.read(buffer).also { length = it } > 0) {
            zipOutputStream.write(buffer, 0, length)
        }

        fileInputStream.close()
    }
}

fun setFilePermissions(filePath: String, permissions: String) {
    val command = "chmod $permissions $filePath"
    try {
        val process = Runtime.getRuntime().exec(command)
        process.waitFor()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

class ZipFolder {
}