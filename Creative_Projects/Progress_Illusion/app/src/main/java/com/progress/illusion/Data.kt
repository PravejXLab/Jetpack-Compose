package com.progress.illusion

import java.time.LocalDate
import java.time.Period

class Data(
    checked1: Boolean = false,
    checked2: Boolean = false,
    checked3: Boolean = false,
    checked4: Boolean = false,
    checked5: Boolean = false,
    checked6: Boolean = false,
    checked7: Boolean = false,
    checked8: Boolean = false,
    checked9: Boolean = false,
    checked10: Boolean = false,
    checked11: Boolean = false,
    checked12: Boolean = false,
    checked13: Boolean = false,
) {
    private fun calculate(year: Int, month: Int, day: Int): Period {
        return Period.between(LocalDate.of(year, month, day), LocalDate.now())
    }

    val toAdd = when {
        !checked1 -> calculate(2025, 5, 31)
        !checked2 -> calculate(2025, 6, 15)
        !checked3 -> calculate(2025, 6, 24)
        !checked4 -> calculate(2025, 7, 2)
        !checked5 -> calculate(2025, 7, 10)
        !checked6 -> calculate(2025, 7, 25)
        !checked7 -> calculate(2025, 8, 6)
        !checked8 -> calculate(2025, 8, 21)
        !checked9 -> calculate(2025, 9, 6)
        !checked10 -> calculate(2025, 9, 21)
        !checked11 -> calculate(2025, 10, 6)
        !checked12 -> calculate(2025, 10, 21)
        !checked13 -> calculate(2025, 10, 31)
        else -> null
    }
}