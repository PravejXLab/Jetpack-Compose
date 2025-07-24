package com.love.ashok.chakra.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SingleStick() {
    Canvas(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {
        drawPath(
            path = Path().apply {
                moveTo(100f, size.height / 2)
                lineTo(size.width / 2, size.height / 3)
                lineTo(size.width - 100f, size.height / 2)
                close()
            },
            color = Color.Blue
        )
    }
}