package de.bsi.kata.tdd.bowling

class Game {

    private val pinsRolled = IntArray(21)

    fun role(pins: Int) {
        pinsRolled[0] = pins
    }

    fun score(): Int {
        return pinsRolled.sum()
    }

}
