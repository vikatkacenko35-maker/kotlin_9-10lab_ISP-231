package outpostState

class OutpostManager {

    val resources = mutableListOf<ObservableResource>()

    init {
        println("Менеджер создан")
    }
    fun addResource(resource: ObservableResource) {
        resources.add(resource)
    }

}