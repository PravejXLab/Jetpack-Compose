package com.basic.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basic.contacts.ui.theme.ContactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsTheme {
                Contacts()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contacts() {
    val names = listOf("Rakesh Manoj", "Sammi Akhtar", "Sameer Raju", "Abhishek Mishra", "Manoj Kushwaha",
        "Raju Allahabadiya", "Salman Ansari", "Manoj Shukla", "Lalu Mina", "Aditya Google",
        "Mani Pichai", "Ravi Verma", "John Kakkar", "Manish Maheshwari", "Tanya Aggarwal",
        "Rani Singh", "Mahi Mukharjee", "Suraj Kapil", "Mona Lisa", "Edward German")

    Scaffold(topBar = {
        TopAppBar(title = { Text("Contacts") })
    }) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues).fillMaxSize().padding(10.dp)) {
            items(names, key = { it }) { name ->
                HorizontalDivider(color = Color.Gray, thickness = 0.5.dp)
                Row(modifier = Modifier.fillMaxWidth().height(50.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painterResource(R.drawable.profile) ,"Logo",
                        modifier = Modifier.size(40.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContactsTheme {
        Contacts()
    }
}