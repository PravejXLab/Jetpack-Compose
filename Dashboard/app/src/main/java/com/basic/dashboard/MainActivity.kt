package com.basic.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dashboard()
        }
    }
}

@Composable
fun CreditCard() {
    Card(Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(25.dp),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.primary
        )) {
        ConstraintLayout(Modifier.fillMaxWidth()) {

            val (txt1, txt2, txt3, txt4) = createRefs()

            Text("January",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.constrainAs(txt1) {
                        top.linkTo(parent.top, margin = 12.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    })
                Text("$500", Modifier.constrainAs(txt2) {
                    top.linkTo(txt1.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                },
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold)

                Text("70% target\nCompleted",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.constrainAs(txt4) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end, margin = 16.dp)
                    bottom.linkTo(parent.bottom)
                })

            Text("Daily spend target: $16.67",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.constrainAs(txt3) {
                    top.linkTo(txt2.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 12.dp)
                })
        }

//        Column(Modifier.padding(8.dp)) {
//
//        }
    }
}

@Composable
fun SeeBox(description: String) {
    Box(Modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(8.dp)) {
        Text(description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.BottomStart),
            color = Color.Gray)
        Text("See All",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.align(Alignment.BottomEnd),
            color = MaterialTheme.colorScheme.primary)
    }
}

@Composable
fun Spends(img: Int, text1: String, text2: String, text3: String, description: String) {
    MaterialTheme {
        ConstraintLayout(Modifier
            .fillMaxWidth()
            .padding(4.dp)) {

            val (img1, txt1, txt2, txt3) = createRefs()
            val barrierForImg = createEndBarrier(img1)

            Image(
                painterResource(img),
                contentDescription = description,
                Modifier
                    .size(50.dp)
                    .constrainAs(img1) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
            Text(text1,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.constrainAs(txt1) {
                    top.linkTo(parent.top)
                    start.linkTo(barrierForImg, margin = 8.dp)
                })
            Text(text2,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.constrainAs(txt2) {
                top.linkTo(txt1.bottom)
                start.linkTo(barrierForImg, margin = 8.dp)
                bottom.linkTo(parent.bottom)
            })
            Text(text3,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.constrainAs(txt3) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        }
    }

}

@Composable
fun Wishlist(img: Int, txt: String, description: String, color: Color) {
    Card(modifier = Modifier
        .size(80.dp)
        .padding(4.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(color)) {

        ConstraintLayout(Modifier.fillMaxSize()) {
            val (img1, txt1) = createRefs()
            val verticalChain = createVerticalChain(img1, txt1)

            Image(painterResource(img), description,
                Modifier
                    .size(30.dp)
                    .constrainAs(img1) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            Text(txt, fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
                modifier = Modifier.constrainAs(txt1) {
                top.linkTo(img1.bottom)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            })
        }
    }

}

@Composable
fun BottomNavigation() {
    NavigationBar {
        NavigationBarItem( 
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, "Home Screen") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Favorite, "Favourite") },
            label = { Text("Wishlist") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Person, "Profile") },
            label = { Text("Profile") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Dashboard() {
    MaterialTheme {
        Scaffold(topBar = {
            TopAppBar( title = {
                Text(text = "Dashboard",
                    fontWeight = FontWeight.Bold)
            },
                actions = {
                    IconButton(onClick = {}, Modifier.padding(horizontal = 10.dp)) {
                        Image(painterResource(R.drawable.boy), "Profile")
                    }
                })
        },
            bottomBar = { BottomNavigation() }

        ) { paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)) {
                CreditCard()
                SeeBox("DAILY SPENDS")
                Surface(modifier = Modifier.fillMaxWidth(),
                    shadowElevation = 10.dp,
                    shape = RoundedCornerShape(corner = CornerSize(15.dp))
                ) {
                    Column(Modifier.padding(8.dp)) {
                    Spends(R.drawable.bank, "Net Banking", "$365.89", "Today", "Net Banking")
                    Spends(R.drawable.food, "Food & Drinks", "$165.99", "22 March 2025", "Food & Drinks")
                    Spends(R.drawable.cloths, "Clothes", "$65.09", "21 March 2025", "Clothes")
                    }
                }
                SeeBox("WISHLIST")
                Row(Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .horizontalScroll(rememberScrollState())) {
                    Wishlist(R.drawable.tee,"Tee", "Tee", Color.Blue)
                    Wishlist(R.drawable.bike,"Bike", "Tee", Color.Magenta)
                    Wishlist(R.drawable.gym,"Gym", "Tee", Color.Black)
                    Wishlist(R.drawable.insurance,"Insurance", "Tee", Color.Red)
                    Wishlist(R.drawable.invest,"Invest", "Tee", Color.Cyan)
                    Wishlist(R.drawable.medicine,"Medicine", "Tee", Color.Green)
                }
            }
        }
    }
}
