package outpostState

import FileStorage
import java.io.File

object StateStorage{
    private const val FILE_NAME = "resource"
    fun save(resources: List<ObservableResource>, filename: String){
        val file = File(filename)
        file.writeText(
            resources.joinToString("\n") {
                "${it.name},${it.amount}"
            }
        )
        println("Состояние базыы сохранено в файд")
    }
    fun load(filename: String): List<ObservableResource> {
        val file = File(filename)
        if (!file.exists()) return emptyList()
        println("Загрузка состояния базы из файла...")
        return file.readLines().map {
            val parts = it.split(",")
            ObservableResource(parts[0], parts[1].toInt())

    }
}}
