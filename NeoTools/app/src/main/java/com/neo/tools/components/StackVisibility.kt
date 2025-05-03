package com.neo.tools.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StackVisibility(
    onClick: () -> Unit,
    onClickAge: () -> Unit,
    onClickDateDifference: () -> Unit,
    onClickFlashlight: () -> Unit,
    onClickProgression: () -> Unit
) {
    var visibility by remember { mutableStateOf(true) }

    Column {
        VisibilityControl(
            visible = visibility,
            onClick = { visibility = !visibility }
        )
        if (visibility) {
            Stack(
                onClick = onClick,
                onClickAge = onClickAge,
                onClickDateDifference = onClickDateDifference,
                onClickFlashlight = onClickFlashlight,
                onClickProgression = onClickProgression
            )
        }
    }
}

@Composable
fun VisibilityControl(
    onClick: () -> Unit,
    visible: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = "Calculator",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(
            modifier = Modifier
                .rotate(if (visible) 0f else -90f),
            onClick = onClick
        ) {
            Icon(Icons.Default.KeyboardArrowDown, "Hide and View")
        }
    }
}