class ResearchLab: OutpostModule("Исследовательская работа") {
    override fun performAction(manager: ResourceManager){
        val minerals = manager.get("Minerals")
        if (minerals == null || minerals.amount < 30){
            println("Недостаточно минералов")
            return
        }
        minerals.amount -= 30
        println("лаба проводит исследования (-30 минералов)")
    }
}