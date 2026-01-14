var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 110) )
            field = value
    }
fun main(){
    println(age)
    age = 45
    println(age)
    age = -345
    println(age)
    val worker = OutpostWorker("Alesha")
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.work()
    worker.work()
    worker.work()
    println("Энергия: ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.rest()
    worker.levelUp()
}