package com.color.magic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.color.magic.ui.theme.ColorMagicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorMagicTheme {
                ColorMagic()
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorMagic() {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Color Magic") },
            colors = TopAppBarDefaults.topAppBarColors(Color.Magenta))
    }) { paddingValues ->
        var count by remember { mutableIntStateOf(0) }
        var a by remember { mutableStateOf("A") }
        var textColor by remember { mutableStateOf(Color.Red) }
        var textColor1 by remember { mutableStateOf(Color.Black) }
        var textColor2 by remember { mutableStateOf(Color.Black) }
        var textColor3 by remember { mutableStateOf(Color.Magenta) }
        var textColor4 by remember { mutableStateOf(Color.Black) }
        var textColor5 by remember { mutableStateOf(Color.Black) }
        var colorRepeat by remember { mutableIntStateOf(3) }


        Column(modifier = Modifier.padding(paddingValues).fillMaxSize()
            .background(color = Color.White)) {
            Spacer(modifier = Modifier.height(50.dp))
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Pick number of colors", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Text("1", fontWeight = FontWeight.Bold, fontSize = 25.sp,
                        color = textColor1,
                        modifier = Modifier.padding(10.dp).clickable {
                            count = (count / colorRepeat) * 1
                            colorRepeat = 1
                            textColor1 = Color.Magenta
                            textColor2 = Color.Black
                            textColor3 = Color.Black
                            textColor4 = Color.Black
                            textColor5 = Color.Black
                            })
                    Text("2", fontWeight = FontWeight.Bold, fontSize = 25.sp,
                        color = textColor2,
                        modifier = Modifier.padding(10.dp).clickable {
                            count = (count / colorRepeat) * 2
                            colorRepeat = 2
                            textColor1 = Color.Black
                            textColor2 = Color.Magenta
                            textColor3 = Color.Black
                            textColor4 = Color.Black
                            textColor5 = Color.Black
                        })
                    Text("3", fontWeight = FontWeight.Bold, fontSize = 25.sp,
                        color = textColor3,
                        modifier = Modifier.padding(10.dp).clickable {
                            count = (count / colorRepeat) * 3
                            colorRepeat = 3
                            textColor1 = Color.Black
                            textColor2 = Color.Black
                            textColor3 = Color.Magenta
                            textColor4 = Color.Black
                            textColor5 = Color.Black
                        })
                    Text("4", fontWeight = FontWeight.Bold, fontSize = 25.sp,
                        color = textColor4,
                        modifier = Modifier.padding(10.dp).clickable {
                            count = (count / colorRepeat) * 4
                            colorRepeat = 4
                            textColor1 = Color.Black
                            textColor2 = Color.Black
                            textColor3 = Color.Black
                            textColor4 = Color.Magenta
                            textColor5 = Color.Black
                        })
                    Text("5", fontWeight = FontWeight.Bold, fontSize = 25.sp,
                        color = textColor5,
                        modifier = Modifier.padding(10.dp).clickable {
                            count = (count / colorRepeat) * 5
                            colorRepeat = 5
                            textColor1 = Color.Black
                            textColor2 = Color.Black
                            textColor3 = Color.Black
                            textColor4 = Color.Black
                            textColor5 = Color.Magenta
                        })
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()) {

                Column {
                    val alphabet = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                        "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

                    Text(a, fontSize = 200.sp,
                        color = textColor,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.clickable {
                            when (colorRepeat) {
                                1 -> if(count <= 24) {
                                    count ++
                                    a = alphabet[count]
                                }

                                2 -> if(count <= 50) {
                                    count ++
                                    a = alphabet[count/2]
                                    if (count % 2 == 1) {
                                        textColor = Color.Green
                                    } else {
                                        textColor = Color.Red
                                    }
                                }

                                3 -> if(count <= 76) {
                                    count ++
                                    a = alphabet[count/3]
                                    if (count % 3 == 1) {
                                        textColor = Color.Green
                                    } else if (count % 3 == 2) {
                                        textColor = Color.Blue
                                    } else {
                                        textColor = Color.Red
                                    }
                                }

                                4 -> if(count <= 102) {
                                    count ++
                                    a = alphabet[count/4]
                                    if (count % 4 == 1) {
                                        textColor = Color.Green
                                    } else if (count % 4 == 2) {
                                        textColor = Color.Blue
                                    } else if (count % 4 == 3) {
                                        textColor = Color.Yellow
                                    } else {
                                        textColor = Color.Red
                                    }
                                }

                                5 -> if(count <= 128) {
                                    count ++
                                    a = alphabet[count/5]
                                    if (count % 5 == 1) {
                                        textColor = Color.Green
                                    } else if (count % 5 == 2) {
                                        textColor = Color.Blue
                                    } else if (count % 5 == 3) {
                                        textColor = Color.Yellow
                                    } else if (count % 5 == 4) {
                                        textColor = Color.Cyan
                                    } else {
                                        textColor = Color.Red
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColorMagicTheme {
        ColorMagic()
    }
}