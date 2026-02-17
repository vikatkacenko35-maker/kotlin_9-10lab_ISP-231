package outpostState

class ResourceObserver {

    fun onResourceChanged(name: String, old: Int, new: Int) {
        println("Наблюдатель: ресурс $name изменился с $old до $new")
    }
}