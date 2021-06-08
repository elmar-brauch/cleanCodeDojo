package de.bsi.kata.tdd.bowling

class Game {

    private val pinsRolled = IntArray(21)
    private var currentRole = 0

    fun role(pins: Int) {
        if (isOver())
            throw IllegalStateException("Game is over.")
        pinsRolled[currentRole] = pins
        if (isStrike(currentRole))
            currentRole++
        currentRole++
    }

    fun score(): Int {
        return pinsRolled.sum()
    }

    private fun isOver() = pinsRolled.size <= currentRole || (currentRole == 20 && (!isSpare(19) || !isStrike(19)))

    private fun isSpare(role: Int) = pinsRolled[role] < 10 &&
            pinsRolled[role] + pinsRolled[role + 1] == 10

    private fun isStrike(role: Int) = pinsRolled[role] == 10

}
