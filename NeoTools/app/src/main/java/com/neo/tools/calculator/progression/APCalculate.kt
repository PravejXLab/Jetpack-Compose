package com.neo.tools.calculator.progression

import androidx.compose.runtime.MutableState

fun APCalculate(
    selected: String,
    options: List<String>,
    firstTerm: String,
    lastTerm: String,
    numberOfTerms: String,
    commonDifference: String,
    result: MutableState<String>,
    sum: MutableState<String>
) {
    when (selected) {
        options[0] -> {
            result.value = try {
                (lastTerm.toDouble() - (numberOfTerms.toInt() - 1) * commonDifference.toDouble()).toString()
            } catch (e: Exception) {
                "I am not able to calculate!"
            }
            sum.value = try {
                (((result.value.toDouble() + lastTerm.toDouble()) * numberOfTerms.toInt()) / 2).toString()
            } catch (e: Exception) {
                "I am not able to Calculate!"
            }
        }
        options[1] -> {
            result.value = try {
                ((lastTerm.toDouble() - firstTerm.toDouble()) / (numberOfTerms.toInt() - 1)).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
            sum.value = try {
                (numberOfTerms.toInt() * (firstTerm.toDouble() + lastTerm.toDouble()) / 2).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
        }
        options[2] -> {
            result.value = try {
                (firstTerm.toDouble() + (numberOfTerms.toInt() - 1) * commonDifference.toDouble()).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
            sum.value = try {
                (numberOfTerms.toInt() * (firstTerm.toDouble() + result.value.toDouble()) / 2).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
        }
        options[3] -> {
            result.value = try {
                (((lastTerm.toDouble() - firstTerm.toDouble()) / commonDifference.toDouble()) + 1).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
            sum.value = try {
                (result.value.toInt() * (firstTerm.toDouble() + lastTerm.toDouble()) / 2).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
        }
    }
}
