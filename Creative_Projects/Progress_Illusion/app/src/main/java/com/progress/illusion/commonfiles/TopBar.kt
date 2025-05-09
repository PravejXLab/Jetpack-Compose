package com.progress.illusion.commonfiles

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import java.time.LocalDate
import java.time.Period

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(reality: LocalDate, expected: LocalDate, title: String) {
    TopAppBar(
        title = { Text(title) },
        actions = { Text(
            text = "${Period.between(reality, expected).days}   ",
            fontWeight = FontWeight.ExtraBold,
            color = if (Period.between(reality, expected).days >= 7) {
                Color.Green
            } else if (Period.between(reality, expected).days in 1..6) {
                Color.Unspecified
            } else {
                Color.Red
            }
        ) }
    )
}