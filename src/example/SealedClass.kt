package example

import javax.annotation.processing.Messager

sealed class Networkresult{
    data class Success(val data: String) : Networkresult()
    data class Error(val message: String, val code: Int) : Networkresult()
    object Loading : Networkresult()
}
fun handleResult(result: Networkresult){
    when (result){
        is Networkresult.Error -> {println("Ошибка ${result.code}: ${result.message}")}
        Networkresult.Loading -> println("Загрузка...")
        is Networkresult.Success -> {println("Успех: ${result.data}")}
    }
}
fun main(){
    val success = Networkresult.Success("Данные получены")
    val error = Networkresult.Error("Сервер не отвечает", 500)
    val  loading = Networkresult.Loading
    handleResult(success)
    handleResult(error)
    handleResult(loading)
}