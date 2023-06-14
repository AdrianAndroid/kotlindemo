package tool

import java.io.File

fun main(args: Array<String>) {
    println("Hello World!!!!")
    println("start...")
    deleteAllBuildDirs(File("/Users/apus/AndroidStudioProjects"))
    println("end.....")
}
/**
 * 批量删除build文件夹
 */
fun deleteAllBuildDirs(file: File) {
    if (file.isDirectory) {
        if ("build" == file.name) {
             file.deleteRecursively() // 批量删除
            println(file.absolutePath)
        } else {
            file.listFiles()?.forEach { f ->
                deleteAllBuildDirs(f)
            }
        }
    }
}

class BuildDirectoryClear {

}