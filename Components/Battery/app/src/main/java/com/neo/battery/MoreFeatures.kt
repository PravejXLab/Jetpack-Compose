package com.neo.battery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MoreFeatures(onClickBatteryAlarm: () -> Unit, onClickAntiTheft: () -> Unit, onClickSmartCharging: () -> Unit, onClickWidget: () -> Unit, ) {
    Column(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(modifier = Modifier.padding(8.dp).weight(1f), onClick = onClickBatteryAlarm) {
                Text("Battery Alarm", textAlign = TextAlign.Center)
            }
            OutlinedButton(modifier = Modifier.padding(8.dp).weight(1f), onClick = onClickAntiTheft) {
                Text("Anti Theft", textAlign = TextAlign.Center)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(modifier = Modifier.padding(8.dp).weight(1f), onClick = onClickSmartCharging) {
                Text("Smart Charging", textAlign = TextAlign.Center)
            }
            OutlinedButton(modifier = Modifier.padding(8.dp).weight(1f), onClick = onClickWidget) {
                Text("Widget", textAlign = TextAlign.Center)
            }
        }
    }
}