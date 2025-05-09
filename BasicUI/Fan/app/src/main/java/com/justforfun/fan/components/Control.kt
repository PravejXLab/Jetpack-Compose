package com.justforfun.fan.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@Composable
fun Control(
    modifier: Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    isRotating: Boolean,
    isRotatingToggle: (Boolean) -> Unit
) {
    Row(modifier = modifier) {
        Column(
            modifier = Modifier
                .weight(3f),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedButton(onClick = { isRotatingToggle(isRotating) }) {
                Text(if (isRotating) "Stop Fan" else "Start Fan")
            }
            Text("${value.toInt()} rotations / sec")
        }
        Column(
            modifier = Modifier
                .weight(2f)
        ) {
            Slider(
                value = value,
                onValueChange = { onValueChange(it) },
                valueRange = 1f..10f,
                steps = 8,
                modifier = Modifier
                    .padding(20.dp)
                    .rotate(-90f)
            )
        }
    }
}