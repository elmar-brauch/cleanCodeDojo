package de.bsi.kata.tdd.bowling

class Game {

    private val pinsRolled = IntArray(21)
    private var role = 0

    fun role(pins: Int) {
        if (pinsRolled.size <= role)
            throw IllegalStateException("Game is over.")
        pinsRolled[role++] = pins
    }

    fun score(): Int {
        return pinsRolled.sum()
    }

}
