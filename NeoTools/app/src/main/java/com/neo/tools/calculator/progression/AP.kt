package com.neo.tools.calculator.progression

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun AP() {
    var firstTerm by remember { mutableStateOf("") }
    var commonDifference by remember { mutableStateOf("") }
    var lastTerm by remember { mutableStateOf("") }
    var numberOfTerms by remember { mutableStateOf("") }
    val options = listOf("First term", "Common diff.", "Last term", "No. of terms")
    var selected by remember { mutableStateOf(options[0]) }
    var visibility by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }
    var sum by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DropdownProgression(
            options = options,
            selected = { selected = it },
            selectedItem = selected
            )
        HorizontalDivider()
        Spacer(Modifier.height(20.dp))

        if (selected != options[0]) {
            InputData(
                name = "First term:",
                value = firstTerm,
                onValueChange = { firstTerm = it }
            )
        }
        if (selected != options[1]) {
            InputData(
                name = "Common diff:",
                value = commonDifference,
                onValueChange = { commonDifference = it }
            )
        }
        if (selected != options[2]) {
            InputData(
                name = "Last term:",
                value = lastTerm,
                onValueChange = { lastTerm = it }
            )
        }
        if (selected != options[3]) {
            InputData(
                name = "No. of terms:",
                value = numberOfTerms,
                onValueChange = { numberOfTerms = it }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    visibility = true
                    numberOfTerms = try {
                        (numberOfTerms.toInt()).toString()
                    } catch(e: Exception) {
                        ""
                    }

                    when (selected) {
                        options[0] -> {
                            result = try {
                                (lastTerm.toFloat() - (numberOfTerms.toInt() - 1) * commonDifference.toFloat()).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }

                            sum = try {
                                (((result.toFloat() + lastTerm.toFloat()) * numberOfTerms.toInt()) / 2).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }
                        }
                        options[1] -> {
                            result = try {
                                ((lastTerm.toFloat() - firstTerm.toFloat()) / (numberOfTerms.toInt() - 1)).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }
                            sum = try {
                                (numberOfTerms.toInt() * (firstTerm.toFloat() + lastTerm.toFloat()) / 2).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }
                        }
                        options[2] -> {
                            result = try {
                                (firstTerm.toFloat() + (numberOfTerms.toInt() - 1) * commonDifference.toFloat()).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }
                            sum = try {
                                (numberOfTerms.toInt() * (firstTerm.toFloat() + result.toFloat()) / 2).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }
                        }
                        options[3] -> {
                            result = try {
                                (((lastTerm.toFloat() - firstTerm.toFloat()) / commonDifference.toFloat()) + 1).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }
                            sum = try {
                                (result.toInt() * (firstTerm.toFloat() + lastTerm.toFloat()) / 2).toString()
                            } catch (e: Exception) {
                                "I am not able to Calculate"
                            }
                        }
                    }
                }
            ) {
                Text("Calculate")
            }
        }

        if (visibility) {
            HorizontalDivider()
            Column(Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "$selected → $result",
                        fontSize = 20.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Sum → $sum",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun InputData(
    name: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.weight(1f))
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.width(100.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}
