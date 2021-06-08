package de.bsi.kata.tdd.bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GameTest {

    private val game = Game()

    @ParameterizedTest
    @CsvSource("0,0,20,", "20,1,20", "150, 5, 21", "300, 10, 12")
    fun fullRoundTest(expectedScore: Int, pins: Int, roles: Int) {
        roleMany(pins, roles)
        assertEquals(expectedScore, game.score())
    }

    @ParameterizedTest
    @CsvSource("5,22,", "1,21", "10,13")
    fun tooManyRolesTest(pins: Int, roles: Int) {
        assertThrows<IllegalStateException> { roleMany(pins, roles) }
    }

    @Test
    fun intermediateScoreTest() {
        game.role(0)
        game.role(10)
        game.role(3)
        game.role(2)
        game.role(10)
        game.role(10)
        game.role(6)
        game.role(3)
        assertEquals(72, game.score())
    }

    private fun roleMany(pins: Int, roles: Int) {
        for (i in 1..roles)
            game.role(pins)
    }

}