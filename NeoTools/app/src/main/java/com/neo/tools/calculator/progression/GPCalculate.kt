package com.neo.tools.calculator.progression

import androidx.compose.runtime.MutableState
import kotlin.math.ln
import kotlin.math.pow

fun GPCalculate(
    selected: String,
    options: List<String>,
    firstTerm: String,
    commonRatio: String,
    lastTerm: String,
    numberOfTerms: String,
    result: MutableState<String>,
    sum: MutableState<String>
) {
    when (selected) {
        options[0] -> {
            result.value = try {
                if (commonRatio.toDouble() != 0.0) {
                    (lastTerm.toDouble() / (commonRatio.toDouble().pow(numberOfTerms.toInt() - 1))).toString()
                } else {
                    "I am not able to calculate!"
                }
            } catch (e: Exception) {
                "I am not able to calculate!"
            }
            sum.value = try {
                (result.value.toDouble() * ((1 - commonRatio.toDouble().pow(numberOfTerms.toDouble())) / (1 - commonRatio.toDouble()))).toString()
            } catch (e: Exception) {
                "I am not able to Calculate!"
            }
        }
        options[1] -> {
            result.value = try {
                (firstTerm.toDouble() * (commonRatio.toDouble().pow(numberOfTerms.toInt() - 1)) / firstTerm.toDouble() * (commonRatio.toDouble().pow(numberOfTerms.toInt() - 2))).toString()
            } catch (e: Exception) {
                "I am not able to Calculate!"
            }
            sum.value = try {
                (firstTerm.toDouble() * (1 - result.value.toDouble().pow(numberOfTerms.toInt())) / (1 - result.value.toDouble())).toString()
            } catch (e: Exception) {
                "I am not able to Calculate!"
            }
        }
        options[2] -> {
            result.value = try {
                (firstTerm.toDouble() * (commonRatio.toDouble().pow(numberOfTerms.toInt() - 1))).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
            sum.value = try {
                (firstTerm.toDouble() * (1 - commonRatio.toDouble().pow(numberOfTerms.toInt()) / (1 - commonRatio.toDouble()))).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
        }
        options[3] -> {
            result.value = try {
                ((ln(lastTerm.toDouble() / firstTerm.toDouble()) / ln(commonRatio.toDouble())) + 1).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
            sum.value = try {
                (firstTerm.toDouble() * (1 - commonRatio.toDouble().pow(result.value.toInt()) / (1 - commonRatio.toDouble()))).toString()
            } catch (e: Exception) {
                "I am not able to Calculate"
            }
        }
    }

}
