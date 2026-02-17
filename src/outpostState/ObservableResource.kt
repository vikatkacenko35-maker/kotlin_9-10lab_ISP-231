package outpostState

import kotlin.properties.Delegates

class ObservableResource(val name: String, initialAmount: Int){
    private val observers = mutableListOf<ResourceObserver>()
    var amount: Int by Delegates.observable(initialAmount){ _, old, new ->
        println("Ресурс $name изменён: $old → $new")
    }
    fun addObserver(observer: ResourceObserver) {
        observers.add(observer)
    }

    private fun notifyObservers(old: Int, new: Int) {
        for (obs in observers) {
            obs.onResourceChanged(name, old, new)
        }
    }
}