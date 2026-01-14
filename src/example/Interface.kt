package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop(){
        println("останавливаемся...")
    }
}
class Car (override val number: String, override val model: String): Movable{
    override var speed = 60
    override fun move(){
        println("Eдeм на машине со скоростью $speed км/ч")
    }}
    class Aircraft(override val number: String, override val model: String) : Movable {
        override var speed = 160
        override fun move() {
            println("Летим на самолетесо скоростью $speed км/ч")
        }
        override fun stop() = println("Приземляемся...")
    }
    fun travel(obj: Movable) = obj.move()
    fun main(){
        val car:Movable = Car("LADA", "134Lad")
        //var car = example.Car()
        val aircraft:Movable = Aircraft("Boeing", "777")
        aircraft.move()
        aircraft.stop()
        travel(car)
        travel(aircraft)
        val pavel = WorkingStudent("Pavel")
        pavel.work()
        pavel.study()
        val player = MediaPLayer()
        player.play()
    }
    interface Worker{
        fun work()
    }
    interface  Student{
        fun study()
    }
    class WorkingStudent(val name: String) : Worker, Student{
        override fun work()  = println("$name is working")
        override fun study() = println("$name is studying")


    }
interface VideoPlayable{
    fun play() = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}
class MediaPLayer: VideoPlayable, AudioPlayable{
    override fun play(){
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}
