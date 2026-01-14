var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 110) )
            field = value
    }
abstract class Human(val name: String){
    fun hello(){
        println("My name is $name")
    }
}
class Person(name: String) : Human(name)
data class Item(val id:Int, val name: String, val quantity: Int){
    override fun toString(): String {
        return "Id предмета: $id\nИмя: $name\nколичество: $quantity\n"
    }
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
    val sword = Item(1, "Sword", 1)
    val betterSword = sword.copy(quantity = 2)
    println(sword.toString())
    println(betterSword.toString())
    val(id, name, quantity) = betterSword
    println("Id предмета: $id\nИмя: $name\nколичество: $quantity\n")
    val vicka: Person = Person("Vicka")
    vicka.hello()
    //val pavel:Human = Human("Pavel")
}
