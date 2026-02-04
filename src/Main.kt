import example.GameHero
import example.InstantMessenger
import example.PhotoCamers
import example.PhotoDevice
import example.SmartPhone
import example.UserProfile
import example.counter
import modules.EnergyGenerator
import modules.ModuleResult
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager
import kotlin.math.min


fun handleModuleResult(result: ModuleResult){
    when(result){
        is ModuleResult.Success -> println("Успех: ${result.message}")
        is ModuleResult.ResourceProduced -> println("Произведено: ${result.resourceName} + ${result.amount}")
        is ModuleResult.NotEnoughResources -> println("Недостаточно ресурсов ${result.resourceName}.\nНужно: ${result.required}, есть: ${result.available}")
        is ModuleResult.Error -> println("Ошибка: ${result.reason}")
    }
}

object SystemLogger{
    init {
        println("SystemLogger инициализирован")
    }

    fun log(message: String){
        println("[LOG] $message")
    }
}
val logger by lazy { SystemLogger }

fun main(){

    logger.log("Запуск базы")

    val manager = ResourceManager()
    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    val generatoresult = generator.performAction(manager)
    val labResult = lab.performAction(manager)
    handleModuleResult(generatoresult)
    handleModuleResult(labResult)
    generator.performAction(manager)
    lab.performAction(manager)

    val loadedresourses = FileStorage.load()
    loadedresourses.forEach { manager.add(it) }

    if(loadedresourses.isEmpty()){
        manager.add(OutpostResource(1, "Minerals", 300))
        manager.add(OutpostResource(2,"Gas", 100))
    }
    val minerals = OutpostResource(1, "Minerals", 300)
    val gas = OutpostResource(2, "Gas", 100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()
    val bonus = minerals.copy(amountInit = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")
    println()
    manager.printAll()
    FileStorage.save(manager.getAll())

    val max = InstantMessenger("MAX")
    //val photoCamera = PhotoCamers()
    val yotaPhone = SmartPhone("yotaPhone", max)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
    //yotaPhone.takePhoto()
    counter = 1
    counter = 5

    println("Создаем профиль пользователя")
    val user = UserProfile("Вика", "vika@gmail.com")

//    println("\n Name: ${user.name}")
//    println("Email: ${user.email}")
//
//    println("\n Обращаемся к аватару впервые:")
//    println("Файл аватараЖ :${user.avatar}")
//
//    println("\n Обращаемся к аватару снова:")
//    println("Файл аватара :${user.avatar}")
//
//    println("Меняем email: ")
//    user.email = "hfjg@gmaol.com"
//
//    println("\n Меняем имя:")
//    user.name = "Вика Т."

    println("Создаем героя...")
    val hero = GameHero("Воин Света")
    println("Текушая мана: ${hero.mana}")

    println("Героц использует способность")
    println("Способность:${hero.ultimate}")
    println("\n Меняем имя:")
    hero.name = "Крутой армянин"

    println("Герой восстанавливает ману")
    hero.mana = 200

}