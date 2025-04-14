package com.time.clock.ui.theme.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TimerValue(
    timer: Int,
    onClickUp: () -> Unit,
    onClickDown: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClickUp) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Increase",
                modifier = Modifier
                    .size(60.dp)
            )
        }
        Text(
            text = timer.toString().padStart(2, '0'),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(onClick = onClickDown) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Decrease",
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }
}

@Composable
fun TimerControl(play:() -> Unit, text: String, reset:() -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedButton(
            modifier = Modifier
                .size(60.dp)
                .defaultMinSize(1.dp),
            onClick = play,
            contentPadding = PaddingValues(0.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                modifier = Modifier.padding(0.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.width(50.dp))
        OutlinedButton(
            modifier = Modifier
                .size(60.dp)
                .defaultMinSize(1.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = reset,
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Text(
                text = "↻",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                modifier = Modifier.padding(0.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TimeLeft(
    hour: Int,
    minute: Int,
    second: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
            .aspectRatio(1f)
            .background(
                color = Color.Unspecified,
                shape = CircleShape
            )
            .border(
                width = 10.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${ hour.toString().padStart(2, '0') }:" +
                    "${ minute.toString().padStart(2, '0')}:" +
                    second.toString().padStart(2, '0'),
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }

}

@Preview(showBackground = true)
@Composable
fun Timer() {
    var hour by rememberSaveable { mutableIntStateOf(0) }
    var minute by rememberSaveable { mutableIntStateOf(0) }
    var second by rememberSaveable { mutableIntStateOf(0) }
    var play by rememberSaveable { mutableStateOf("▶") }
    var visible by rememberSaveable { mutableStateOf(true) }
    var isRunning by rememberSaveable { mutableStateOf(false) }
    var timeLeftInSec by rememberSaveable { mutableIntStateOf(0) }
    val context = LocalContext.current

    if (isRunning) {
        LaunchedEffect(Unit) {
            timeLeftInSec = (hour * 3600) + (minute * 60) + second
            while (timeLeftInSec > 0) {
                delay(1000)
                timeLeftInSec--
                second--
                if(second == -1) {
                    second = 59
                    minute--
                    if (minute == -1) {
                        minute = 59
                        hour--
                    }
                }
                if (timeLeftInSec == 0) {
                    delay(1000)
                    isRunning = false
                    visible = true
                    play = "▶"
                    Toast.makeText(context, "Timer Ended", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        if (visible) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TimerValue(
                    timer = hour,
                    onClickUp = { hour++ },
                    onClickDown = { if (hour > 0) hour-- }
                )
                TimerValue(
                    timer = minute,
                    onClickUp = { if(minute < 59) minute++ else minute = 0},
                    onClickDown = { if (minute > 0) minute-- else minute = 59}
                )
                TimerValue(
                    timer = second,
                    onClickUp = { if(second < 59) second++ else second = 0},
                    onClickDown = { if (second > 0) second-- else second = 59}
                )
            }
        } else {
            TimeLeft(
                hour = hour,
                minute = minute,
                second = second
            )
        }

        TimerControl(
            play = {
                if (hour > 0 || minute > 0 || second > 0) {
                    play = if (play == "▶") "| |" else "▶"
                    visible = false
                    isRunning = !isRunning
                }
            },
            text = play,
            reset = {
                hour = 0
                minute = 0
                second = 0
                play = "▶"
                visible = true
                isRunning = false
            }
        )
    }
}