package com.user.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.user.authentication.ui.theme.AuthenticationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthenticationTheme {
                Authentication()
            }
        }
    }
}

@Composable
fun UserInfo(value: String, onValueChange: (String) -> Unit, labelName: String) {

    Spacer(Modifier.height(10.dp))
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Enter your $labelName") })
}

@Composable
fun Signup() {
    MaterialTheme {
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(50.dp))
            Row(Modifier.fillMaxWidth().padding(20.dp),
                horizontalArrangement = Arrangement.Center) {
                Text("SignUP", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                    style = TextStyle(color = MaterialTheme.colorScheme.onBackground)
                ) }
            OutlinedCard(Modifier
                .padding(horizontal = 20.dp)
                .wrapContentSize()
                .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(10.dp)) {
                Column(Modifier.padding(20.dp)) {
                    UserInfo(name, { name = it }, "Name")
                    UserInfo(email, { email = it },"Email")
                    UserInfo(password, { password = it },"Password")

                    Spacer(Modifier.height(20.dp))

                    Row(Modifier.padding(10.dp)) {
                        FilledTonalButton(onClick = {},
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = Color.Red,
                                contentColor = Color.White),
                            modifier = Modifier.fillMaxWidth(),
                            elevation = ButtonDefaults.filledTonalButtonElevation(5.dp)) {
                            Text("Sign UP", fontSize = 20.sp,
                                fontWeight = FontWeight.Bold)
                        } }
                    HorizontalDivider(thickness = 0.8.dp)

                    Row(Modifier.fillMaxWidth().padding(20.dp),
                        horizontalArrangement = Arrangement.Center) {
                        Image(painter = painterResource(R.drawable.google),
                            contentDescription = "Google SignUP",
                            Modifier.size(30.dp))
                        Spacer(Modifier.width(30.dp))
                        Image(painter = painterResource(R.drawable.facebook),
                            contentDescription = "Facebook SignUP",
                            Modifier.size(30.dp))
                    }

                    Row(Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(3f),
                            horizontalAlignment = Alignment.End) {
                            Text("Already have an account?")
                        }
                        Column(Modifier.weight(1f),
                            horizontalAlignment = Alignment.Start) {
                            TextButton(onClick = {},
                                Modifier.wrapContentSize()) {
                                Text("Login")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Authentication() {
    Signup()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AuthenticationTheme {
        Authentication()

    }
}