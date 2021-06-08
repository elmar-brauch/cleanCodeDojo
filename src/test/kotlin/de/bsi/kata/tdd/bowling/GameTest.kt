package de.bsi.kata.tdd.bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

    val game = Game()

    @Test
    fun roleOnly0() {
        game.role(0)
        assertEquals(0, game.score())
    }

    @Test
    fun roleOnly1() {
        game.role(1)
        assertEquals(1, game.score())
    }

}