package example

import kotlin.properties.Delegates


interface Base{
    fun someFun()
}
class BaseImpl(): Base{
    override fun someFun() {
        TODO("Not yet implemented")
    }
}
class Derived(someBase: Base): Base by someBase
interface Messenger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessenger(val programName: String) : Messenger{
    override fun sendTextMessage() {
        println("MEssage  has been send")
    }override fun sendVideoMessage() {
        println("Video has been send")
    }
}
class SmartPhone(val name: String, m: Messenger): Messenger by m{
    override fun sendTextMessage() {
        println("Send sms")
    }
}

interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamers: PhotoDevice{
    override fun takePhoto() {
        println("Take a photo")
    }
}
class User{
    var name: String by Delegates.observable("<no name>"){ _, old, new -> println("Имя изменено: '$old -> $new'")}
}
var counter: Int by Delegates.observable(0){_, old, new -> println("Counter has been changes: $old -> $new")}