package com.neo.battery

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun BatteryTips(navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = { TopBar(navController, "Battery Tips") }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "What about charging the battery?", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp, top = 16.dp))
            TipBox("◈ Charge when battery is near 30%", "Lithium ion batteries perform better in range 20% to 80%, frequently reducing to low battery may decrease battery life.")
            TipBox("◈ Charge when convenient, no need to wait for low battery", "You can charge anytime as long as temperature is normal, this misconception of charging when battery is low is false.")
            TipBox("◈ Don't let the battery go below 10%", "Such activity may lead to degradation of battery causes performance issue. The voltage drops sharply creates stress on battery.")
            TipBox("◈ Avoid charging to 100%", "Its not too dangerous, you can, when you really need. But, avoid repeating it daily as it leads faster battery aging.")
            TipBox("◈ Temperature is the biggest enemy", "Avoid temperature beyond 15°C to 40°C, it should be avoided always, during using, charging or putting under hot weather. Also, avoid charging under pillows and blankets and in parked car under sun.")
            TipBox("◈ Remove phone case when battery is hot", "Covers of phone trap the internal temperature, removing it when battery is hot, specially during charging is a good practice. Also, removing phone covers may increase battery temperature if external temperature is more than internal.")
            TipBox("◈ Don't use phone during charging", "Its not dangerous if temperature is maintained, but fast charging plus aggressive using can generate a lot of heat. Battery may burn or explode in worst case scenario.")
            TipBox("◈ Use proper heat dissipation method during fast charging", "Fast charging is safe only when temperature is under 40°C, If heat is not controllable - Remove phone case, charge in night, opt for slow or night charging, charge with short intervals etc.")
            Text(text = "What if, you don't have to use your device for long time?", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp, top = 16.dp))
            TipBox("◈ Charge 50% and switch off, if you don't have to use your phone", "If you have to leave your phone unused for few days or sometimes, always charge to around 50% as it retains battery health.")
            TipBox("◈ Keeping at 0% or 100% for long time is not safe", "Completely discharge for many days switched off can permanently damage the battery. Putting at 100% for long time unused can degrade the battery.")
            TipBox("◈ Store your device at cold and dry place", "Store your device at a place where humidity is low, temperature is around 25°C and no sign of electrical appliances.")
            Text(text = "How to save most of your battery?", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp, top = 16.dp))
            TipBox("◈ Generally, the main reason of fast battery drain is brightness", "Avoid high brightness all the time. Enable auto brightness as it balance between battery life and required brightness to see your screen clearly. Additionally, this feature is also helpful for your eyes.")
            TipBox("◈ Keep all unnecessary connections off like wifi, data, GPS, Bluetooth etc.", "If not in use, keep all these features off, turn on when needed and off again. If absolutely not needed, you can turn on flight mode or switch off you device like in night before sleep.")
            TipBox("◈ Use dark mode interface all the time", "Being habitual to this feature is a good practice, saves your battery and helpful for your eye as well.")
            TipBox("◈ Use static wallpaper and set minimum screen on time", "Live wallpaper uses more battery, use either black which is best or at least an static image. Also make sure to turn off screen when not in use.")
            TipBox("◈ Limit apps that run in background and use power saving mode when needed", "You can check background running apps from setting and turn off them. Battery saving mode is made for this, it regularly checks and kills the most battery using services.")
            Text(text = "How to save your battery life?", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp, top = 16.dp))
            TipBox("◈ Use your own charger and adapters", "Chargers are optimised according to phone like cutting high voltage etc. Different chargers may provide unstable power, which can damage the battery or even cause fire. Or, use manufacturer recommended and safety certified charges like CE, MFi etc.")
            TipBox("◈ Avoid charging via weak power sources like Computer USB or power bank", "These weak sources provide slow or unstable power that can cause slow charging and overheating and can significantly affect battery voltage, which may leads to degradation of battery over time.")
            TipBox("◈ Monitor charging cables and and charger often", "Sometimes cables or chargers get damaged to a small amount which may cause heat and provide unstable power which is dangerous for your health. Frayed, broken cables and loose plugs should be repaired or replace immediately.")
            TipBox("◈ Replace the battery if swollen or causes overheating", "This is dangerous sign and replace it immediately otherwise it may leads to fire which not just damage your phone but any contact surface may burn.")
        }
    }
}

@Composable
fun TipBox(heading: String, detail: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = heading,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = detail,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}