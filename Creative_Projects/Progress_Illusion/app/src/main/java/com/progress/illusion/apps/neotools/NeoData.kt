package com.progress.illusion.apps.neotools

import java.time.LocalDate
import java.time.Period

class NeoData(
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
    checked14: Boolean = false,
    checked15: Boolean = false,
    checked16: Boolean = false,
    checked17: Boolean = false,
    checked18: Boolean = false,
    checked19: Boolean = false,
    checked20: Boolean = false,
    checked21: Boolean = false,
    checked22: Boolean = false,
    checked23: Boolean = false,
    checked24: Boolean = false,
    checked25: Boolean = false,
    checked26: Boolean = false,
    checked27: Boolean = false,
    checked28: Boolean = false,
    checked29: Boolean = false,
    checked30: Boolean = false,
    checked31: Boolean = false,
    checked32: Boolean = false,
    checked33: Boolean = false,
    checked34: Boolean = false,
    checked35: Boolean = false,
    checked36: Boolean = false,
    checked37: Boolean = false,
    checked38: Boolean = false,
    checked39: Boolean = false,
    checked40: Boolean = false,
    checked41: Boolean = false,
    checked42: Boolean = false,
    checked43: Boolean = false,
    checked44: Boolean = false,
    checked45: Boolean = false,
    checked46: Boolean = false,
    checked47: Boolean = false,
    checked48: Boolean = false,
    checked49: Boolean = false,
    checked50: Boolean = false,
    checked51: Boolean = false,
    checked52: Boolean = false,
    checked53: Boolean = false,
    checked54: Boolean = false,
    checked55: Boolean = false,
    checked56: Boolean = false,
    checked57: Boolean = false,
    checked58: Boolean = false,
    checked59: Boolean = false,
    checked60: Boolean = false,
    checked61: Boolean = false,
    checked62: Boolean = false,
    checked63: Boolean = false,
    checked64: Boolean = false,
    checked65: Boolean = false,
    checked66: Boolean = false,
    checked67: Boolean = false,
    checked68: Boolean = false,
    checked69: Boolean = false,
    checked70: Boolean = false,
    checked71: Boolean = false,
    checked72: Boolean = false,
    checked73: Boolean = false,
    checked74: Boolean = false,
    checked75: Boolean = false,
    checked76: Boolean = false,
    checked77: Boolean = false,
    checked78: Boolean = false
) {
    private fun calculate(year: Int, month: Int, day: Int): Period {
        return Period.between(LocalDate.of(year, month, day), LocalDate.now())
    }

    val toAdd = when {
        !checked1 -> calculate(2025, 5, 10)
        !checked2 -> calculate(2025, 5, 10)
        !checked3 -> calculate(2025, 5, 10)
        !checked4 -> calculate(2025, 5, 11)
        !checked5 -> calculate(2025, 5, 11)
        !checked6 -> calculate(2025, 5, 11)
        !checked7 -> calculate(2025, 5, 11)
        !checked8 -> calculate(2025, 5, 12)
        !checked9 -> calculate(2025, 5, 12)
        !checked10 -> calculate(2025, 5, 12)
        !checked11 -> calculate(2025, 5, 12)
        !checked12 -> calculate(2025, 5, 13)
        !checked13 -> calculate(2025, 5, 13)
        !checked14 -> calculate(2025, 5, 13)
        !checked15 -> calculate(2025, 5, 13)
        !checked16 -> calculate(2025, 5, 14)
        !checked17 -> calculate(2025, 5, 14)
        !checked18 -> calculate(2025, 5, 14)
        !checked19 -> calculate(2025, 5, 14)
        !checked20 -> calculate(2025, 5, 15)
        !checked21 -> calculate(2025, 5, 15)
        !checked22 -> calculate(2025, 5, 15)
        !checked23 -> calculate(2025, 5, 15)
        !checked24 -> calculate(2025, 5, 16)
        !checked25 -> calculate(2025, 5, 16)
        !checked26 -> calculate(2025, 5, 16)
        !checked27 -> calculate(2025, 5, 16)
        !checked28 -> calculate(2025, 5, 17)
        !checked29 -> calculate(2025, 5, 17)
        !checked30 -> calculate(2025, 5, 17)
        !checked31 -> calculate(2025, 5, 17)
        !checked32 -> calculate(2025, 5, 18)
        !checked33 -> calculate(2025, 5, 18)
        !checked34 -> calculate(2025, 5, 18)
        !checked35 -> calculate(2025, 5, 18)
        !checked36 -> calculate(2025, 5, 19)
        !checked37 -> calculate(2025, 5, 19)
        !checked38 -> calculate(2025, 5, 19)
        !checked39 -> calculate(2025, 5, 19)
        !checked40 -> calculate(2025, 5, 20)
        !checked41 -> calculate(2025, 5, 20)
        !checked42 -> calculate(2025, 5, 20)
        !checked43 -> calculate(2025, 5, 20)
        !checked44 -> calculate(2025, 5, 21)
        !checked45 -> calculate(2025, 5, 21)
        !checked46 -> calculate(2025, 5, 21)
        !checked47 -> calculate(2025, 5, 21)
        !checked48 -> calculate(2025, 5, 22)
        !checked49 -> calculate(2025, 5, 22)
        !checked50 -> calculate(2025, 5, 22)
        !checked51 -> calculate(2025, 5, 22)
        !checked52 -> calculate(2025, 5, 23)
        !checked53 -> calculate(2025, 5, 23)
        !checked54 -> calculate(2025, 5, 23)
        !checked55 -> calculate(2025, 5, 23)
        !checked56 -> calculate(2025, 5, 24)
        !checked57 -> calculate(2025, 5, 24)
        !checked58 -> calculate(2025, 5, 24)
        !checked59 -> calculate(2025, 5, 24)
        !checked60 -> calculate(2025, 5, 25)
        !checked61 -> calculate(2025, 5, 25)
        !checked62 -> calculate(2025, 5, 25)
        !checked63 -> calculate(2025, 5, 25)
        !checked64 -> calculate(2025, 5, 26)
        !checked65 -> calculate(2025, 5, 26)
        !checked66 -> calculate(2025, 5, 26)
        !checked67 -> calculate(2025, 5, 26)
        !checked68 -> calculate(2025, 5, 27)
        !checked69 -> calculate(2025, 5, 27)
        !checked70 -> calculate(2025, 5, 27)
        !checked71 -> calculate(2025, 5, 27)
        !checked72 -> calculate(2025, 5, 28)
        !checked73 -> calculate(2025, 5, 28)
        !checked74 -> calculate(2025, 5, 28)
        !checked75 -> calculate(2025, 5, 28)
        !checked76 -> calculate(2025, 5, 29)
        !checked77 -> calculate(2025, 5, 29)
        !checked78 -> calculate(2025, 5, 29)
        else -> null
    }
}
