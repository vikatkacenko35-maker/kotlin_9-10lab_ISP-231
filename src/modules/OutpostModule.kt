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
    abstract fun performAction(manager: ResourceManager) : ModuleResult

}