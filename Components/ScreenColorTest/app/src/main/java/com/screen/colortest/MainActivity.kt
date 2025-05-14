package com.screen.colortest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.godaddy.android.colorpicker.ClassicColorPicker
import com.godaddy.android.colorpicker.HsvColor
import com.screen.colortest.ui.theme.ScreenColorTestTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenColorTestTheme {
                ScreenTest()
            }
        }
    }
}

@Composable
fun ScreenTest() {
    var background by remember { mutableStateOf(Color.Unspecified) }
    var colorPickerVisible by remember { mutableStateOf(false) }
    var fabVisible by remember { mutableStateOf(true) }

    if (colorPickerVisible) {
        Dialog(onDismissRequest = { colorPickerVisible = false }) {
            Box(Modifier.height(200.dp)) {
                ClassicColorPicker(
                    color = HsvColor.from(color = background),
                    onColorChanged = { background = it.toColor() })
            }
        }
    }



    Scaffold(
        floatingActionButton = {
            if (fabVisible) {
                FloatingActionButton(onClick = { colorPickerVisible = true }) {
                    Icon(painterResource(R.drawable.pallete), "Pick color")
                }
                LaunchedEffect(Unit) {
                    delay(3000)
                    fabVisible = false
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
                .clickable { fabVisible = !fabVisible }
                .padding(innerPadding)
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScreenColorTestTheme {
        ScreenTest()
    }
}