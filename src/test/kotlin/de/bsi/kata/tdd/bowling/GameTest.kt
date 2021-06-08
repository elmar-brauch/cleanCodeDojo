package de.bsi.kata.tdd.bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun bowlingGame() {
        val game = Game()
        game.role(0)
        assertEquals(0, game.score())
    }

}