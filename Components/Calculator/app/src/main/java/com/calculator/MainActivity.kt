package com.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Calculator()
            }
        }
    }
}

@Composable
fun Calculator() {
    var expression by remember { mutableStateOf("0") }
    var finalResult by remember { mutableStateOf("") }
    val numOperators by remember { mutableStateOf(listOf("C", "%", "⌫", "/", "1", "2", "3", "*", "4", "5", "6", "-", "7", "8", "9", "+", "00", "0", ".", "=")) }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom) {
                Text(expression, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
            Column(Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom) {
                Text(finalResult, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(16.dp))
            Column(Modifier.padding(8.dp)) {
                LazyVerticalGrid(columns = GridCells.Fixed(4)) {
                    items(numOperators) { item ->
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                                .padding(4.dp)
                                .border(1.dp, Color.LightGray)
                                .clickable {
                                    when (item) {
                                        numOperators[0] -> {
                                            expression = "0"
                                            finalResult = ""
                                        }

                                        numOperators[1] -> {
                                            expression = if (expression.last() == '/' || expression.last() == '*' || expression.last() == '-' || expression.last() == '+' || expression.last() == '.') {
                                                expression
                                            } else {
                                                "$expression%"
                                            }
                                        }

                                        numOperators[2] -> {
                                            expression = expression.dropLast(1)
                                        }

                                        numOperators[3], numOperators[7], numOperators[11], numOperators[15] -> {
                                            expression = when (expression.last()) {
                                                '/', '*', '-', '+' -> {
                                                    expression.dropLast(1) + item
                                                }
                                                else -> expression + item
                                            }
                                        }

                                        numOperators[16] -> {
                                            expression = if (expression != "0") expression + "00" else "0"
                                        }

                                        numOperators[18] -> {
                                            expression = if (expression.last() == '/' || expression.last() == '*' || expression.last() == '-' || expression.last() == '+' || expression.last() == '%' || expression.last() == '.') {
                                                expression
                                            } else {
                                                "$expression."
                                            }
                                        }

                                        numOperators[19] -> {
                                            val regex = Regex("(?<=[+\\-*/%])|(?=[+\\-*/%])")

                                            val tokens = regex.split(expression).toMutableList()

                                            val operators = listOf("/", "%", "*", "-", "+")

                                            if (expression.last() == '/' || expression.last() == '*' || expression.last() == '-' || expression.last() == '+' || expression.last() == '.') {
                                                // Do nothing
                                            } else {

                                                try {
                                                    for (operator in operators) {
                                                        while(tokens.contains(operator)) {
                                                            val multiplyIndex = tokens.indexOf(operator)
                                                            val multiplied = when(operator) {
                                                                "/" -> tokens[multiplyIndex - 1].toDouble() / tokens[multiplyIndex + 1].toDouble()
                                                                "%" -> tokens[multiplyIndex - 1].toDouble() * 0.01
                                                                "*" -> tokens[multiplyIndex - 1].toDouble() * tokens[multiplyIndex + 1].toDouble()
                                                                "-" -> tokens[multiplyIndex - 1].toDouble() - tokens[multiplyIndex + 1].toDouble()
                                                                "+" -> tokens[multiplyIndex - 1].toDouble() + tokens[multiplyIndex + 1].toDouble()
                                                                else -> null
                                                            }
                                                            if (operator != "%") {
                                                                tokens.removeAt(multiplyIndex + 1)
                                                                tokens.removeAt(multiplyIndex)
                                                                tokens.removeAt(multiplyIndex - 1)
                                                                tokens.add(multiplyIndex - 1, multiplied.toString())
                                                            } else {
                                                                if (expression.last() == '%') {
                                                                    tokens.removeAt(multiplyIndex)
                                                                    tokens.removeAt(multiplyIndex - 1)
                                                                    tokens.add(multiplyIndex - 1, "$multiplied")
                                                                } else {
                                                                    tokens.removeAt(multiplyIndex)
                                                                    tokens.removeAt(multiplyIndex - 1)
                                                                    tokens.add(multiplyIndex - 1, "$multiplied")
                                                                    if (tokens[multiplyIndex] == "+" || tokens[multiplyIndex] == "-" || tokens[multiplyIndex] == "*" || tokens[multiplyIndex] == "/") {
                                                                        // Do nothing
                                                                    } else {
                                                                        tokens.add(multiplyIndex, "*")
                                                                    }

                                                                }
                                                            }
                                                        }
                                                    }
                                                } catch (e: Exception) {
                                                    // Do nothing
                                                }

                                                val result = tokens[0]

                                                finalResult = if (result == result.toDouble().toInt().toDouble().toString()) {
                                                    result.toDouble().toInt().toString()
                                                } else {
                                                    result
                                                }
                                            }
                                        }
                                        else -> expression =
                                            if (expression != "0") expression + item else item
                                    }
                                },
                            Alignment.Center) { Text(item, fontWeight = FontWeight.ExtraBold, fontSize = 25.sp) }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Calculator()
    }
}