package com.basic.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basic.profile.ui.theme.ProfileTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileTheme {
                Profile()
            }
        }
    }
}

@Composable
fun UserInfo(name: String, image: Painter) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .size(40.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = image,
            contentDescription = "Ranking",
            modifier = Modifier.size(35.dp))
        Spacer(modifier = Modifier.width(30.dp))
        Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Primary() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            Text("Pravej", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(x = 10.dp, y = 10.dp))
            Text("Pushing Harder to build Consistency!",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.BottomCenter))
            Image(painter = painterResource(R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(70.dp)
                    .offset(y = -10.dp))
        }
    }
}

@Composable
fun Secondary() {
    Card(modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Gray),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            UserInfo("Ranking", image = painterResource(R.drawable.ranking))
            HorizontalDivider(color = Color.Gray)
            UserInfo("Calender", painterResource(R.drawable.calender))
        }
    }
}

@Composable
fun Tertiary() {
    Card(modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Gray),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            UserInfo("Store", painterResource(R.drawable.cart))
            HorizontalDivider(color = Color.Gray)
            UserInfo("Privacy Policy", painterResource(R.drawable.privacy))
            HorizontalDivider(color = Color.Gray)
            UserInfo("Invite Friends", painterResource(R.drawable.invite))
            HorizontalDivider(color = Color.Gray)
            UserInfo("Help", painterResource(R.drawable.help))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile() {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Profile") },
            actions = { IconButton(onClick = {}) {
                Icon(Icons.Default.Settings, contentDescription = "Setting")
            } }
        )
    }) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(20.dp)) {
            Primary()
            Spacer(modifier = Modifier.height(30.dp))
            Secondary()
            Spacer(modifier = Modifier.height(30.dp))
            Tertiary()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileTheme {
        Profile()
    }
}