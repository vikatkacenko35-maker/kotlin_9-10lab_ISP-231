package gameCharacter

class GameCharacter(val name: String) {
    var currentState: CharacterState = CharacterState.Idle
    fun changeState(newState: CharacterState) {
        currentState = newState
    }
}