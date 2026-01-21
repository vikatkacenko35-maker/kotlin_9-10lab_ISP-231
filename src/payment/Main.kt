package payment

fun main(){
    val processor = Paymentprocessor()
    val payments = listOf(
        Payment("4_111_111_111_111_111", 1000, CardType.VISA),
        Payment("5_111_111_111_111_111", 2000, CardType.MASTERCARD),
        Payment("2_222_222_222_222_222", 1500, CardType.MIR),
        Payment("123456487565574567865", 500, CardType.UNKNOWN),
        Payment("123", 3000, CardType.VISA)
    )
    println("===Обработка платежей===")
    payments.forEach { payment ->
        println("\nПлатеж ${payment.type}: ${payment.card.take(4)}..., ${payment.sum} руб.")
        val result = processor.pay(payment)
        processor.show(result)
    }
    println("Работа с enum")
    val cardType = CardType.VISA
    println("тип карты: ${cardType}")
    println("Порядковый номер: ${cardType.ordinal}")
    println("Все типы карт: ${CardType.values().joinToString()}")

    val payment1 = Payment("411111111111111111111", 1000, CardType.VISA)
    val payment2 = payment1.copy(type = CardType.MASTERCARD, sum = 2000)

    println("\nСравнение data class")
    println("Платеж 1: $payment1")
    println("Платеж 2: $payment2")
    println("Одинаковые? ${payment1 == payment2}")
}