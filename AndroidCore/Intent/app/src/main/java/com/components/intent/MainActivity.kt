package com.components.intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.components.intent.components.DialNumber
import com.components.intent.components.IntentSetting
import com.components.intent.components.MakeCall
import com.components.intent.components.OpenURL
import com.components.intent.components.SecondActivity
import com.components.intent.components.SendEmail
import com.components.intent.components.SendMessage
import com.components.intent.components.ShareText
import com.components.intent.ui.theme.IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "home") {
                    composable("home") { IntentActions(navController) }
                    composable("OpenURL") { OpenURL() }
                    composable("DialNumber") { DialNumber() }
                    composable("MakeCall") { MakeCall() }
                    composable("SendMessage") { SendMessage() }
                    composable("SendEmail") { SendEmail() }
                    composable("ShareText") { ShareText() }
                    composable("IntentSetting") { IntentSetting() }
                }
            }
        }
    }
}

@Composable
fun IntentActions(navController: NavController) {
    val context = LocalContext.current
    val items = listOf("Open URL", "Dial Number", "Make Call", "Send Message", "Send Email", "Share Text", "Intent Setting", "Second Activity")

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(items) { item ->
                    Surface(
                        modifier = Modifier
                            .padding(8.dp)
                            .border(width = 1.dp, shape = RoundedCornerShape(corner = CornerSize(12.dp)), color = Color.LightGray)
                            .shadow(elevation = 12.dp, shape = RoundedCornerShape(corner = CornerSize(12.dp))),
                        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
                        onClick = { navController.navigate(
                            when (item) {
                                items[0] -> "OpenURL"
                                items[1] -> "DialNumber"
                                items[2] -> "MakeCall"
                                items[3] -> "SendMessage"
                                items[4] -> "SendEmail"
                                items[5] -> "ShareText"
                                items[6] -> "IntentSetting"
                                //items[7] -> "SecondActivity"
                                else -> ""
                            }
                        )
                            if (item == items[7]) {
                                val intent = Intent(context, SecondActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(intent)
                            }
                        }
                    )  {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.Unspecified, shape = RoundedCornerShape(corner = CornerSize(12.dp)))
                                .aspectRatio(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(item, textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntentTheme {
        val fake = rememberNavController()
        IntentActions(fake)
    }
}