package com.neo.battery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material.Slider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun BatteryAlarm(navController: NavController = rememberNavController()) {
    Scaffold( topBar = { TopBar(navController, "Battery Alarm") }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(innerPadding)
        ) {
            ReminderSurface()
            ReminderSurface()
        }
    }
}

@Composable
fun ReminderSurface() {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Battery Full",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp
                )
                Switch(
                    modifier = Modifier.scale(0.75f),
                    checked = true,
                    onCheckedChange = {}
                )
            }
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(12.dp)),
                //border = BorderStroke(1.dp, Color.Gray)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("Battery Level", Modifier.padding(top = 8.dp, start = 8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Slider(
                            modifier = Modifier.weight(1f),
                            value = 100f,
                            onValueChange = {},
                            valueRange = 0f..100f
                        )
                        Spacer(Modifier.width(16.dp))
                        Text("20%", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(R.drawable.vibrate), "Control Vibration")
                        Text("Vibration", modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .weight(1f))
                        Switch(
                            modifier = Modifier.scale(0.75f),
                            checked = true,
                            onCheckedChange = {}
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(R.drawable.notification_sound), "Change Notification Sound")
                        Column(Modifier.fillMaxWidth().weight(1f)) {
                            Text("Alarm Sound", modifier = Modifier.padding(horizontal = 8.dp))
                            Text("Power full", modifier = Modifier.padding(horizontal = 8.dp), color = MaterialTheme.colorScheme.primary)
                        }
                        Switch(
                            modifier = Modifier.scale(0.75f),
                            checked = true,
                            onCheckedChange = {}
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(R.drawable.alarm_sound), "Change Alarm Sound")
                        Column(Modifier.fillMaxWidth().weight(1f)) {
                            Text("Alarm Sound", modifier = Modifier.padding(horizontal = 8.dp))
                            Text("Oating", modifier = Modifier.padding(horizontal = 8.dp), color = MaterialTheme.colorScheme.primary)
                        }
                        Switch(
                            modifier = Modifier.scale(0.75f),
                            checked = true,
                            onCheckedChange = {}
                        )
                    }
                }
            }
        }
    }
    Spacer(Modifier.height(8.dp))
}