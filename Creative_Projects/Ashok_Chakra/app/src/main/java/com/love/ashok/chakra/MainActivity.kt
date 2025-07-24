package com.love.ashok.chakra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import com.love.ashok.chakra.ui.theme.AshokChakraTheme
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AshokChakraTheme {
                AshokChakra()
            }
        }
    }
}

@Composable
fun AshokChakra() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Canvas(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.width / 2 - 100f

            drawCircle(
                brush = Brush.verticalGradient(colors = listOf(Color(0xFFF16C05), Color.White, Color.Green)),
                radius = radius,
                center = center
            )
            drawCircle(
                color = Color.Blue,
                radius = 50f,
                center = center
            )
            for (n in 1..25) {
                drawPath(
                    path = Path().apply {
                        moveTo(center.component1(), center.component2())
                        lineTo(
                            getEndOffsetLine1(n * 15.0, center, radius).component1(),
                            getEndOffsetLine1(n * 15.0, center, radius).component2()
                        )
                        lineTo(
                            getEndOffset(n * 15.0, center, radius).component1(),
                            getEndOffset(n * 15.0, center, radius).component2()
                        )
                        lineTo(
                            getEndOffsetLine2(n * 15.0, center, radius).component1(),
                            getEndOffsetLine2(n * 15.0, center, radius).component2()
                        )
                        close()
                    },
                    color = Color.Blue
                )
            }
        }
    }
}

fun getEndOffsetLine1(angle: Double, center: Offset, radius: Float) : Offset {
    val angleInRadian = Math.toRadians(angle - 5).toFloat()
    val endX = center.x + radius / 2.5 * cos(angleInRadian)
    val endY = center.y + radius / 2.5 * sin(angleInRadian)
    return Offset(endX.toFloat(), endY.toFloat())
}
fun getEndOffsetLine2(angle: Double, center: Offset, radius: Float) : Offset {
    val angleInRadian = Math.toRadians(angle + 5).toFloat()
    val endX = center.x + radius / 2.5 * cos(angleInRadian)
    val endY = center.y + radius / 2.5 * sin(angleInRadian)
    return Offset(endX.toFloat(), endY.toFloat())
}
fun getStartOffsetLine3(angle: Double, center: Offset, radius: Float) : Offset {
    val angleInRadian = Math.toRadians(angle + 5).toFloat()
    val startX = center.x + radius / 2.5 * cos(angleInRadian)
    val startY = center.y + radius / 2.5 * sin(angleInRadian)
    return Offset(startX.toFloat(), startY.toFloat())
}
fun getStartOffsetLine4(angle: Double, center: Offset, radius: Float) : Offset {
    val angleInRadian = Math.toRadians(angle - 5).toFloat()
    val startX = center.x + radius / 2.5 * cos(angleInRadian)
    val startY = center.y + radius / 2.5 * sin(angleInRadian)
    return Offset(startX.toFloat(), startY.toFloat())
}
fun getEndOffset(angle: Double, center: Offset, radius: Float) : Offset {
    val angleInRadian = Math.toRadians(angle).toFloat()
    val endX = center.x + radius * cos(angleInRadian)
    val endY = center.y + radius * sin(angleInRadian)
    return Offset(endX, endY)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AshokChakraTheme {
        AshokChakra()
    }
}