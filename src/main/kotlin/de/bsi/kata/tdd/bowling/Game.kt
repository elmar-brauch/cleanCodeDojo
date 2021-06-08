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
        var sum = pinsRolled[18] + pinsRolled[19] + pinsRolled[20]
        for (role in 0..17) {
            sum += pinsRolled[role]
            if (isSpare(role))
                sum += pinsRolled[role + 1]
        }
        return sum
    }

    private fun isOver() = currentRole > 20 || currentRole == 20 && !(isSpare(18) || isStrike(18))

    private fun isSpare(role: Int) = role % 2 == 0 && pinsRolled[role] < 10 &&
            pinsRolled[role] + pinsRolled[role + 1] == 10

    private fun isStrike(role: Int) = role % 2 == 0 && pinsRolled[role] == 10

}
