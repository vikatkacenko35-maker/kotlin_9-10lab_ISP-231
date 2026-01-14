package modules

import modules.EnergyGenerator
import resources.OutpostResource
import modules.ResearchLab
import resources.ResourceManager

abstract class OutpostModule (val name: String,
    var level: Int = 1){
    fun upgrade(){
        level++
        println("$name улучшен до уровня $level")
    }
    abstract fun performAction(manager: ResourceManager)
    fun main(){
        val manager = ResourceManager()
        manager.add(OutpostResource(1, "Minerals", 120))
        manager.add(OutpostResource(2, "Gas", 40))
        val generator = EnergyGenerator()
        val lab = ResearchLab()
        generator.performAction(manager)
        lab.performAction(manager)
        println()
        manager.printAll()
    }
}