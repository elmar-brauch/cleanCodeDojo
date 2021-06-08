package de.bsi.kata.tdd.bowling

class Game {

    private val pinsRolled = IntArray(21)
    private var currentRole = 0

    fun role(pins: Int) {
        if (pinsRolled.size <= currentRole || (currentRole == 20 && !isSpare(19)))
            throw IllegalStateException("Game is over.")
        pinsRolled[currentRole++] = pins
    }

    fun score(): Int {
        return pinsRolled.sum()
    }

    private fun isSpare(role: Int) = pinsRolled[role] < 10 &&
            pinsRolled[role] + pinsRolled[role + 1] == 10

}
