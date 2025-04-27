package com.neo.tools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.neo.tools.calculator.age.AgeCalculator
import com.neo.tools.calculator.date_difference.DateDifference
import com.neo.tools.components.StackVisibility
import com.neo.tools.components.TopBar
import com.neo.tools.ui.theme.NeoToolsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NeoToolsTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { NeoTools(navController) }
                    composable("Age Calculator") { AgeCalculator(navController) }
                    composable("Date difference") { DateDifference(navController) }
                }
            }
        }
    }
}

@Composable
fun NeoTools(navController: NavController) {
    Scaffold(
        topBar = { TopBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            StackVisibility(
                onClick = {},
                onClickAge = { navController.navigate("Age Calculator") },
                onClickDateDifference = { navController.navigate("Date Difference")},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NeoToolsTheme {
        val fakeNavController = rememberNavController()
        NeoTools(navController = fakeNavController)
    }
}