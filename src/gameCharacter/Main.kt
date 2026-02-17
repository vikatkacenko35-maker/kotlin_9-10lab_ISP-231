package gameCharacter


fun handleState(state: CharacterState) {
    when (state) {
        is CharacterState.Idle -> println("Персонаж бездействует")
        is CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attack -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Dead -> println("Персонаж погиб: ${state.reason}")
    }
}

fun main(){
    val hero = GameCharacter("Рыцарь")
    handleState(hero.currentState)
    hero.changeState(CharacterState.Running)
    handleState(hero.currentState)
    hero.changeState(CharacterState.Attack(50))
    handleState(hero.currentState)
    hero.changeState(CharacterState.Dead("убит боссом"))
    handleState(hero.currentState)
}