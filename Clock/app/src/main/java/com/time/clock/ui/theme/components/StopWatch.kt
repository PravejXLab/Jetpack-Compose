package com.time.clock.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun StopWatch() {
    var hour by rememberSaveable { mutableIntStateOf(0) }
    var minute by rememberSaveable { mutableIntStateOf(0) }
    var second by rememberSaveable { mutableIntStateOf(0) }
    var milliSec by rememberSaveable { mutableIntStateOf(0) }
    var play by rememberSaveable { mutableStateOf("▶") }

    if (play == "| |") {
        LaunchedEffect(Unit) {
            while (true) {
                delay(10)
                milliSec += 1
                if (milliSec == 100) {
                    milliSec = 0
                }
            }
        }

        LaunchedEffect(Unit) {
            while (true) {
                delay(1000)
                second++
                if (second == 60) {
                    second = 0
                    minute++
                    if (minute == 60) {
                        minute = 0
                        hour++
                    }
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 50.dp, end = 50.dp, bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.Unspecified,
                    shape = CircleShape
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${hour.toString().padStart(2, '0')}:" +
                        "${minute.toString().padStart(2, '0')}:" +
                        "${second.toString().padStart(2, '0')}",
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(milliSec.toString().padStart(2, '0'),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Spacer(Modifier.height(70.dp))
        StopWatchControl(
            play = { play = if (play == "▶") "| |" else "▶" },
            text = play,
            reset = {
                hour = 0
                minute = 0
                second = 0
                play = "▶"
            }
        )
    }
}

@Composable
fun StopWatchControl(play:() -> Unit, text: String, reset:() -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            modifier = Modifier
                .size(60.dp)
                .defaultMinSize(1.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = play,
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(0.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(Modifier.width(50.dp))
        OutlinedButton(
            onClick = reset,
            modifier = Modifier
                .size(60.dp)
                .defaultMinSize(1.dp),
            contentPadding = PaddingValues(0.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "↻",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}