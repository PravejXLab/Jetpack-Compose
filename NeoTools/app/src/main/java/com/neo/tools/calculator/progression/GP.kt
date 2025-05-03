package com.neo.tools.calculator.progression

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun GP() {
    var visibility by remember { mutableStateOf(false) }
    val options = listOf("First term", "Common ratio", "Last term", "No. of terms")
    var selected by remember { mutableStateOf(options[0]) }
    var firstTerm by remember { mutableStateOf("") }
    var commonRatio by remember { mutableStateOf("") }
    var lastTerm by remember { mutableStateOf("") }
    var numberOfTerms by remember { mutableStateOf("") }
    val result = remember { mutableStateOf("") }
    val sum = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DropdownProgression(
            options = options,
            selectedItem = selected,
            selected = { selected = it },
        )
        HorizontalDivider()
        Spacer(Modifier.height(20.dp))

        if (selected != options[0] ) {
            InputData(
                name = "First term:",
                value = firstTerm,
                onValueChange = { firstTerm = it }
            )
        }
        if (selected != options[1] ) {
            InputData(
                name = "Common ratio:",
                value = commonRatio,
                onValueChange = { commonRatio = it }
            )
        }
        if (selected != options[2] ) {
            InputData(
                name = "Last term:",
                value = lastTerm,
                onValueChange = { lastTerm = it }
            )
        }
        if (selected != options[3] ) {
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
                        numberOfTerms.toDouble().toInt().toString()
                    } catch(e: Exception) {
                        ""
                    }

                    GPCalculate(
                        selected = selected,
                        options = options,
                        firstTerm = firstTerm,
                        commonRatio = commonRatio,
                        lastTerm = lastTerm,
                        numberOfTerms = numberOfTerms,
                        result = result,
                        sum = sum
                    )
                }

            ) {
                Text("Calculate")
            }
        }

        if (visibility) {
            result.value = if (result.value.toDouble().toInt().toDouble() == result.value.toDouble()) {
                result.value.toDouble().toInt().toString()
            } else {
                result.value
            }

            sum.value = if (sum.value.toDouble().toInt().toDouble() == sum.value.toDouble()) {
                sum.value.toDouble().toInt().toString()
            } else {
                sum.value
            }

            HorizontalDivider()
            Column(Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "$selected → ${result.value}",
                        fontSize = 20.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Sum → ${sum.value}",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}