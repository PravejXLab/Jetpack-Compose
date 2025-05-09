package com.rock.paper.scissor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.rock.paper.scissor.ui.theme.RockPaperScissorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RockPaperScissorTheme {
                Game()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar( title = {
        Text("Game")
    })
}

@Composable
fun Game() {
    Scaffold(topBar = { TopBar() }) { innerPadding ->
        MaterialTheme {
            ConstraintLayout(Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
                var isVisible by remember { mutableStateOf(false) }
                var userChoice by remember { mutableStateOf("") }
                var cpuChoice by remember { mutableStateOf("") }
                var resultColor by remember { mutableStateOf(Color.Unspecified) }
                val (set1, set2, set3, set4) = createRefs()
                val verticalChain = createVerticalChain(set1, set2, set3, set4)

                Column(Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .constrainAs(set1) {
                        top.linkTo(parent.top)
                    }) {

                    Row(Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                        horizontalArrangement = Arrangement.Center) {
                        Text("Your Choice",
                            style = MaterialTheme.typography.titleLarge)
                    }
                    Row(Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                        ConstraintLayout(Modifier.fillMaxWidth()) {
                            val (text1, text2, text3) = createRefs()

                            val horizontalChain = createHorizontalChain(text1, text2, text3)

                            Text("🪨", fontSize = 50.sp,
                                modifier = Modifier
                                    .clickable {
                                        isVisible = true
                                        userChoice = "🪨"
                                        cpuChoice = listOf("🪨", "📃", "✂️").random()
                                    }
                                    .constrainAs(text1) {
                                        start.linkTo(parent.start)
                                    })
                            Text("📃", fontSize = 50.sp,
                                modifier = Modifier
                                    .clickable {
                                        isVisible = true
                                        userChoice = "📃"
                                        cpuChoice = listOf("🪨", "📃", "✂️").random()
                                    }
                                    .constrainAs(text2) {
                                        start.linkTo(text1.end)
                                    })
                            Text("✂️", fontSize = 50.sp,
                                modifier = Modifier
                                    .clickable {
                                        isVisible = true
                                        userChoice = "✂️"
                                        cpuChoice = listOf("🪨", "📃", "✂️").random()
                                    }
                                    .constrainAs(text3) {
                                        start.linkTo(text2.end)
                                        end.linkTo(parent.end)
                                    })

                        }

                    }
                }

                Row(Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .constrainAs(set2) {
                        top.linkTo(set1.bottom)
                    }) {
                    ConstraintLayout(Modifier.fillMaxWidth()) {
                        val (surface1, surface2) = createRefs()
                        val horizontalChain = createHorizontalChain(surface1, surface2)

                        Surface(modifier = Modifier
                            .shadow(elevation = 10.dp)
                            .constrainAs(surface1) {
                            start.linkTo(parent.start)
                        },
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                            shape = RoundedCornerShape(corner = CornerSize(10.dp))
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(16.dp)) {
                                Text("You Selected")
                                if (isVisible) {
                                    Text(userChoice, style = MaterialTheme.typography.headlineLarge)
                                }
                            }

                        }
                        Surface(modifier = Modifier
                            .shadow(elevation = 10.dp)
                            .constrainAs(surface2) {
                            start.linkTo(surface1.end)
                            end.linkTo(parent.end)
                        },
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                            shape = RoundedCornerShape(corner = CornerSize(10.dp))
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(16.dp)) {
                                Text("CPU Selected")
                                if (isVisible) {
                                    Text(cpuChoice, style = MaterialTheme.typography.headlineLarge)
                                }
                            }
                        }
                    }

                }

                Column(Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .constrainAs(set3) {
                        top.linkTo(set2.bottom)
                    }) {
                    Row(Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                        horizontalArrangement = Arrangement.Center) {
                        Text("CPU Choice",
                            style = MaterialTheme.typography.titleLarge)
                    }
                    Row(Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                        ConstraintLayout(Modifier.fillMaxWidth()) {
                            val (text1, text2, text3) = createRefs()

                            val horizontalChain = createHorizontalChain(text1, text2, text3)

                            Text("🪨", fontSize = 50.sp,
                                modifier = Modifier
                                    .constrainAs(text1) {
                                        start.linkTo(parent.start)
                                    })
                            Text("📃", fontSize = 50.sp,
                                modifier = Modifier
                                    .constrainAs(text2) {
                                        start.linkTo(text1.end)
                                    })
                            Text("✂️", fontSize = 50.sp,
                                modifier = Modifier
                                    .constrainAs(text3) {
                                        start.linkTo(text2.end)
                                        end.linkTo(parent.end)
                                    })

                        }
                    }
                }

                Row(Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .constrainAs(set4) {
                        top.linkTo(set3.bottom)
                        bottom.linkTo(parent.bottom)
                    },
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(if (isVisible) {
                        if (userChoice == cpuChoice) {
                            resultColor = Color.Unspecified
                            "Match drawn!"
                        } else {
                            if (userChoice == "🪨" && cpuChoice == "📃") {
                                resultColor = Color.Red
                                "You Lose! Paper wraps rock"
                            } else if (userChoice == "🪨" && cpuChoice == "✂️") {
                                resultColor = Color.Green
                                "You Won! stone can break the scissor"
                            } else if (userChoice == "📃" && cpuChoice == "🪨") {
                                resultColor = Color.Green
                                "You Won! paper wraps stone"
                            } else if (userChoice == "📃" && cpuChoice == "✂️") {
                                resultColor = Color.Red
                                "You Lose! Scissor cuts paper"
                            } else if (userChoice == "✂️" && cpuChoice == "🪨") {
                                resultColor = Color.Red
                                "You Lose! Stone breaks scissor"
                            } else if (userChoice == "✂️" && cpuChoice == "📃") {
                                resultColor = Color.Green
                                "You Won! Scissor breaks paper"
                            } else {
                                resultColor = Color.Red
                                "Something went wrong!" }
                        }
                    } else {
                        resultColor = Color.Unspecified
                        "Result..."
                    },
                        style = MaterialTheme.typography.titleMedium,
                        color = resultColor)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RockPaperScissorTheme {
        Game()
    }
}