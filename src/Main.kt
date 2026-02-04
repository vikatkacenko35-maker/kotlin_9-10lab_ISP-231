import example.InstantMessenger
import example.PhotoCamers
import example.PhotoDevice
import example.SmartPhone
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



fun main(){

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

    val minerals = OutpostResource(1, "Minerals", 300)
    val gas = OutpostResource(2, "Gas", 100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()
    val bonus = minerals.copy(amount = minerals.amount + 50)
    println("Копия минералов с бонусом: $bonus")
    println()
    manager.printAll()

    val max = InstantMessenger("MAX")
    //val photoCamera = PhotoCamers()
    val yotaPhone = SmartPhone("yotaPhone", max)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
    //yotaPhone.takePhoto()
    counter = 1
    counter = 5
}