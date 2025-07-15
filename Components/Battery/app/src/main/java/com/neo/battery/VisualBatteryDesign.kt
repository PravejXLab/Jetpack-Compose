package com.neo.battery

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.lerp
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun VisualBatteryDesign(percentage: Int = 0, chargingStatus: String = "Unknown") {
    val clampedValue = percentage.coerceIn(0, 99)
    
    val color by animateColorAsState(

        targetValue = if (chargingStatus == "Charging") {
            Color(0xFF05CB6F)
        } else {
            if (percentage >= 60) {
                Color(0xFF05CB6F)
            } else if (percentage <= 20) {
                Color.Red
            } else {
                lerp(
                    Color.Red,
                    Color(0xFF05CB6F),
                    ((percentage - 20) / 40f).coerceIn(0f, 1f)
                )
            }
        },
        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxWidth().height(125.dp)) {

            val batteryWidth = ( size.width - 30 ) * ( clampedValue / 99f )

            drawRoundRect(
                color = color,
                cornerRadius = CornerRadius(15f),
                size = Size(batteryWidth, size.height)
            )
            drawRoundRect(
                color = color,
                cornerRadius = CornerRadius(15f),
                size = Size(size.width - 30, size.height),
                style = Stroke(7f),
            )
            if (percentage != 100) {
                drawRect(
                    color = color,
                    topLeft = Offset(size.width - 30, size.height / 2 - 25),
                    size = Size(20f, 50f),
                    style = Stroke(7f)
                )
            } else {
                drawRect(
                    color = color,
                    topLeft = Offset(size.width - 30, size.height / 2 - 25),
                    size = Size(20f, 50f)
                )
            }
        }
        Text(
            text = "$percentage%",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}