package com.progress.illusion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.progress.illusion.apps.neotools.NeoTools
import com.progress.illusion.commonfiles.TopBar
import com.progress.illusion.ui.theme.ProgressIllusionTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgressIllusionTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "home") {
                    composable("home") { ProgressIllusion(navController) }
                    composable("NeoTools") { NeoTools() }
                }
            }
        }
    }
}

@Composable
fun ProgressIllusion(navController: NavController) {
    val expected by remember { mutableStateOf(LocalDate.of(2025, 10, 31)) }
    var reality by remember { mutableStateOf(LocalDate.of(2025, 10, 31)) }

    LaunchedEffect(Unit) {
        val extra = Data().toAdd
        reality = reality.plus(extra)
    }

    Scaffold(
        topBar = {
            TopBar(reality = reality, expected = expected, title = "Progress Illusion vs Reality")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            AppListStack(navController)
            Spacer(Modifier.height(50.dp))
            Status(show = expected, color = Color.Unspecified, text = "Expected")
            Status(show = reality, color = if (expected.isAfter(reality)) Color.Unspecified else Color.Red, text = "Reality")
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(if (expected.isAfter(reality)) "Shabash Beta! Keep pushing👋" else "Sharam kar saale, khud ko visionary bolta hai aur ek skill " +
                        "tujhse nahi sikhi ja rhi, yahi haal raha na to GSoc bhi nikal jayega aur zindagi bhar sapne dhekhna Elon banne ki")
            }
        }
    }
}

@Composable
fun AppListStack(navController: NavController) {
    Column {
        AppList("NeoTools (31 May)", false, navController = navController, route = "NeoTools")
        AppList("Screen content tracker (15 June)", false, navController = navController, route = "NeoTools")
        AppList("Who touched my Phone (24 June)", false, navController = navController, route = "NeoTools")
        AppList("Advanced Sports app (2 July)", false, navController = navController, route = "NeoTools")
        AppList("Remote, control & Mirror (10 July)", false, navController = navController, route = "NeoTools")
        AppList("Language compiler (25 july)", false, navController = navController, route = "NeoTools")
        AppList("Advanced weather app (6 August)", false, navController = navController, route = "NeoTools")
        AppList("Advanced file manager (21 August)", false, navController = navController, route = "NeoTools")
        AppList("Advanced focus app (6 September)", false, navController = navController, route = "NeoTools")
        AppList("Advanced Browser (21 September)", false, navController = navController, route = "NeoTools")
        AppList("Dream gambling app (6 October)", false, navController = navController, route = "NeoTools")
        AppList("Distraction control launcher (21 October)", false, navController = navController, route = "NeoTools")
        AppList("Test my android phone (31 October)", false, navController = navController, route = "NeoTools")
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProgressIllusionTheme {
        val fake = rememberNavController()
        ProgressIllusion(fake)
    }
}