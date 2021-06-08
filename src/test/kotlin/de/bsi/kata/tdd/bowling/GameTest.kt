package de.bsi.kata.tdd.bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GameTest {

    private val game = Game()

    @ParameterizedTest
    @CsvSource("0,0,20,", "20,1,20")
    fun roleTest(expectedScore: Int, pins: Int, roles: Int) {
        roleMany(pins, roles)
        assertEquals(expectedScore, game.score())
    }

    @Test
    fun tooManyRolesTest() {
        assertThrows<IllegalStateException> { roleMany(5, 22) }
    }

    private fun roleMany(pins: Int, roles: Int) {
        for (i in 1..roles)
            game.role(pins)
    }

}