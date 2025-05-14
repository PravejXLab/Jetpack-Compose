package com.progress.illusion.apps.neotools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.progress.illusion.commonfiles.CommonAppList
import com.progress.illusion.commonfiles.TopBar
import java.time.LocalDate

@Preview(showBackground = true)
@Composable
fun NeoTools() {
    val expected by remember { mutableStateOf(LocalDate.of(2025, 5, 31)) }
    var reality by remember { mutableStateOf(LocalDate.of(2025, 5, 31)) }

    val extra = NeoData().toAdd
    reality = reality.plus(extra)

    Scaffold(
        topBar = {
            TopBar(reality = reality, expected = expected, title = "NeoTools Track Record")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(state = rememberScrollState())
        ) {
            NeoAppListStack()
            Spacer(Modifier.height(50.dp))
            Status(show = expected, color = Color.Unspecified, text = "Expected")
            Status(show = reality, color = if (expected.isAfter(reality)) Color.Unspecified else Color.Red, text = "Reality")
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(if (expected.isAfter(reality)) "Shabash Beta! Keep pushing👋" else "Ye speed rhi to Elon tujhe internship bhi na de!")
            }
        }
    }
}

@Composable
fun NeoAppListStack() {
    Column() {
        CommonAppList("Compass", true)
        CommonAppList("Screen Light", true)
        CommonAppList("Calculator", true)
        CommonAppList("Notes", false)
        CommonAppList("Unit Converter", false)
        CommonAppList("Fuel Cost", false)
        CommonAppList("Measurement", false)
        CommonAppList("QR Generator", false)
        CommonAppList("Battery", false)
        CommonAppList("QR/Bar Code Scanner", false)
        CommonAppList("Jewellery Price", false)
        CommonAppList("Magnifier", false)
        CommonAppList("Compress", false)
        CommonAppList("HEX To RGB", false)
        CommonAppList("Text Converter", false)
        CommonAppList("Aspect Ratio", false)
        CommonAppList("Electricity Bill", false)
        CommonAppList("Energy", false)
        CommonAppList("Audio Recorder", false)
        CommonAppList("Audio Recorder", false)
        CommonAppList("Sound Level", false)
        CommonAppList("Piano", false)
        CommonAppList("Text to Speech", false)
        CommonAppList("TSpeech to text", false)
        CommonAppList("Currency", false)
        CommonAppList("Password Generator", false)
        CommonAppList("Square Feet", false)
        CommonAppList("Number base", false)
        CommonAppList("Quadratic Equation", false)
        CommonAppList("Equation", false)
        CommonAppList("Permutation & Combination", false)
        CommonAppList("Binary & Number", false)
        CommonAppList("Inductor & Resistor", false)
        CommonAppList("Dog Whistle", false)
        CommonAppList("Periodic table", false)
        CommonAppList("Stopwatch", false)
        CommonAppList("World time", false)
        CommonAppList("Calendar", false)
        CommonAppList("Time zone", false)
        CommonAppList("Mirror", false)
        CommonAppList("Translator", false)
        CommonAppList("Metal detector", false)
        CommonAppList("Vibrometer", false)
        CommonAppList("Metronome", false)
        CommonAppList("File transfer", false)
        CommonAppList("Walkie talkie", false)
        CommonAppList("Wifi calls", false)
        CommonAppList("Scribber", false)
        CommonAppList("My address", false)
        CommonAppList("Remainder", false)
        CommonAppList("Signal Strength", false)
        CommonAppList("Path tracker", false)
        CommonAppList("Room temperature", false)
        CommonAppList("Color detector", false)
        CommonAppList("Motion Cam", false)
        CommonAppList("Camera", false)
        CommonAppList("Heart rate", false)
        CommonAppList("Steps tracker", false)
        CommonAppList("BMI", false)
        CommonAppList("Metal Detector", false)
        CommonAppList("Screen Recorder", false)
        CommonAppList("Paint", false)
        CommonAppList("EMI", false)
        CommonAppList("Number Counter", false)
        CommonAppList("Device info", false)
        CommonAppList("Calculator", false)
        CommonAppList("Fuel cost split", false)
        CommonAppList("SIP", false)
        CommonAppList("RD/FD", false)
        CommonAppList("PPF", false)
        CommonAppList("Income tax", false)
        CommonAppList("GST", false)
        CommonAppList("Credit card", false)
        CommonAppList("Pomodoro", false)
        CommonAppList("Distance", false)
        CommonAppList("Ohm's law", false)
        CommonAppList("Color blindness test", false)
        CommonAppList("Morse code", false)
        CommonAppList("Custom unit calculator", false)
    }
}

@Composable
fun Status(show: LocalDate, color: Color, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$text: ${show.dayOfMonth} ${show.month}\n",
            color = color
        )
    }
}