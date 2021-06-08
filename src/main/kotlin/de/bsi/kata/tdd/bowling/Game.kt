package de.bsi.kata.tdd.bowling

const val LAST_FRAME = 18
const val ALL_PINS = 10

class Game {

    private val pinsRolled = IntArray(21)
    private var currentRole = 0

    fun role(pins: Int) {
        if (isOver())
            throw IllegalStateException("Game is over.")
        pinsRolled[currentRole] = pins
        if (isStrike(currentRole) && currentRole < LAST_FRAME)
            currentRole++
        currentRole++
    }

    fun score(): Int {
        var sum = pinsRolled.filterIndexed { index, _ -> index >= LAST_FRAME }.sum()
        for (role in 0 until LAST_FRAME) {
            sum += pinsRolled[role]
            if (isSpare(role))
                sum += pinsRolled[role+2]
            if (isStrike(role))
                sum += pinsRolled[role+2] + if (isStrike(role+2)) pinsRolled[role+4] else pinsRolled[role+3]
        }
        return sum
    }

    private fun isOver() = currentRole > 20 || currentRole == 20 && !(isSpare(LAST_FRAME) || isStrike(LAST_FRAME))

    private fun isSpare(role: Int) = role % 2 == 0 && pinsRolled[role] < ALL_PINS &&
            pinsRolled[role] + pinsRolled[role + 1] == ALL_PINS

    private fun isStrike(role: Int) = role % 2 == 0 && pinsRolled[role] == ALL_PINS

}
