package de.bsi.kata.tdd.bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

    private val game = Game()

    @Test
    fun roleOnly0() {
        roleMany(0, 20)
        assertEquals(0, game.score())
    }

    @Test
    fun roleOnly1() {
        roleMany(1, 20)
        assertEquals(20, game.score())
    }

    private fun roleMany(pins: Int, roles: Int) {
        for (i in 1..roles)
            game.role(pins)
    }

}