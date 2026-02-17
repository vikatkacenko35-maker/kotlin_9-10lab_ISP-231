package outpostState

import java.io.File

fun main(){
    val manager by lazy { OutpostManager() }
    val observer = ResourceObserver()
    val minerals = ObservableResource("Minerals", 100)
    minerals.addObserver(observer)

    val gas = ObservableResource("Gas", 50)
    gas.addObserver(observer)

    manager.addResource(minerals)
    manager.addResource(gas)
    minerals.amount = 120
    gas.amount = 80
    StateStorage.save(manager.resources, "save.txt")
    println("Состояние сохранено\n")
    val loaded = StateStorage.load("save.txt")

    println("Загруженные ресурсы:")
    for (res in loaded) {
        println("${res.name} = ${res.amount}")
    }
}