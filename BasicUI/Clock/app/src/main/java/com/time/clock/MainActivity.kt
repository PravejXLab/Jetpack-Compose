package com.time.clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.time.clock.ui.theme.ClockTheme
import com.time.clock.ui.theme.components.StopWatch
import com.time.clock.ui.theme.components.Timer
import com.time.clock.ui.theme.components.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClockTheme {
                Clock()

            }
        }
    }
}

@Composable
fun Clock() {
    var visible by remember { mutableStateOf(true) }

    Scaffold(topBar = { TopBar(
        onClick = { visible = !visible},
        navigateBack = {

        }
    ) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally) {

            if (visible) Timer() else StopWatch()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClockTheme {
        Clock()
    }
}