package com.neo.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.neo.battery.ui.theme.BatteryTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BatteryTheme {
                val navController = rememberNavController()

                NavHost(navController, "home") {
                    composable("home") { Battery(navController) }
                    composable("BatteryTips") { BatteryTips(navController) }
                    composable("BatteryAlarm") { BatteryAlarm(navController) }
                    composable("AntiTheft") { AntiTheft(navController) }
                    composable("SmartCharging") { SmartCharging(navController) }
                    composable("Widget") { Widget(navController) }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Battery(navController: NavController) {
    val context = LocalContext.current
    var chargingStatus by remember { mutableStateOf("Unknown") }
    var plugSource by remember { mutableStateOf("Unknown") }
    var voltage by remember { mutableDoubleStateOf(0.0) }
    var health by remember { mutableStateOf("Unknown") }
    var batteryPercentage by remember { mutableIntStateOf(0) }
    var batteryTemperature by remember { mutableDoubleStateOf(0.0) }
    var batteryTechnology by remember { mutableStateOf("Unknown") }

    DisposableEffect(Unit) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {

                val plugSourceInt = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
                plugSource = when (plugSourceInt) {
                    BatteryManager.BATTERY_PLUGGED_AC -> "AC"
                    BatteryManager.BATTERY_PLUGGED_USB -> "USB"
                    BatteryManager.BATTERY_PLUGGED_DOCK -> "Dock"
                    BatteryManager.BATTERY_PLUGGED_WIRELESS -> "Wireless"
                    else -> "Unplugged"
                }

                val statusInt = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
                chargingStatus = when {
                    statusInt == BatteryManager.BATTERY_STATUS_CHARGING -> "Charging"
                    statusInt == BatteryManager.BATTERY_STATUS_FULL -> "Completed"
                    plugSourceInt == 0 -> "Discharging"
                    statusInt == BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "Not Charging"
                    else -> "Unknown"
                }

                val healthInt = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1)
                health = when (healthInt) {
                    BatteryManager.BATTERY_HEALTH_COLD -> "Cold"
                    BatteryManager.BATTERY_HEALTH_DEAD -> "Dead"
                    BatteryManager.BATTERY_HEALTH_GOOD -> "Good"
                    BatteryManager.BATTERY_HEALTH_OVERHEAT -> "Overheat"
                    BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> "Over Voltage"
                    BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> "Failed"
                    else -> "Unknown"
                }

                val voltageInt = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)
                voltage = if (voltageInt != -1) voltageInt / 1000.0 else 0.0

                val batteryPercentageInt = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                batteryPercentage = batteryPercentageInt

                val temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)
                batteryTemperature = temperature / 10.0

                val batteryTechnologyString = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY) ?: "Unknown"
                batteryTechnology = batteryTechnologyString
            }
        }

        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        context.registerReceiver(receiver, filter)

        onDispose {
            try {
                context.unregisterReceiver(receiver)
            } catch (_: IllegalArgumentException) {
                // Already unregistered!
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Battery") },
                actions = {
                    IconButton(onClick = { navController.navigate("BatteryTips")}) {
                        Icon(painter = painterResource(R.drawable.battery_tips), "Battery Tips")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
        ) {

            VisualBatteryDesign(batteryPercentage, chargingStatus)

            Spacer(Modifier.height(25.dp))

            Spacer(Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                BatteryDetailCard(modifier = Modifier.weight(1f), "Status", chargingStatus, if (chargingStatus == "Charging") Color(0xFF38C007) else if (chargingStatus == "Unknown") Color.Unspecified else Color.Red)
                BatteryDetailCard(modifier = Modifier.weight(1f), "Plugged", plugSource, if (plugSource == "Unplugged") Color.Red else if (plugSource == "Unknown") Color.Unspecified else Color(0xFF38C007))
                BatteryDetailCard(modifier = Modifier.weight(1f), "Voltage", if (voltage != 0.0) String.format(Locale.US, "%.2f V", voltage) else "Unknown", if (voltage in 3.5..4.1) Color(0xFF38C007) else if (voltage == 0.0) Color.Unspecified else Color.Red)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                BatteryDetailCard(modifier = Modifier.weight(1f), "Health", health, if (health == "Good") Color(0xFF38C007) else if (health == "Unknown") Color.Unspecified else Color.Red)
                BatteryDetailCard(modifier = Modifier.weight(1f), "Temperature", String.format(Locale.US, "%.1f °C", batteryTemperature), if (batteryTemperature in 15.0..40.0) Color(0xFF38C007)  else Color.Red)
                BatteryDetailCard(modifier = Modifier.weight(1f), "Technology", batteryTechnology, Color.Unspecified)
            }

            Spacer(Modifier.height(25.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BatteryTheme {
        val navController = rememberNavController()
        Battery(navController)
    }
}