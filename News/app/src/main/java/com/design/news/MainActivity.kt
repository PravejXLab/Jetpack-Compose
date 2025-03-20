package com.design.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.news.ui.theme.NewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsTheme {
                News()
            }
        }
    }
}

@Composable
fun Data() {
    MaterialTheme {
        var selectedCategory by remember { mutableStateOf("Technology") }
        val categories = listOf("Technology", "Business", "Politics", "Sports", "Bollywood")

        val technologyNews = listOf(
            "Top Billionaires Who Are Building Their Own Cities",
            "What is the meaning of \"i\" in iPhone, iPad?",
            "Canada Has Had Enough Of Tesla")
        val technologyImages = listOf(
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5)

        val businessNews = listOf(
            "3 Smartest People On Earth According To Elon Musk",
            "Jeet Adani steps in with Rs 1 crore offer after Srikanth Bolla",
            "Infosys, TCS gain up to 2%: Why are IT stocks rising today?")
        val businessImages = listOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2)

        val sportsNews = listOf(
            "Hardik Pandya angers Rohit Sharma by uttering CSK",
            "When Ravindra Jadeja was banned for a season",
            "Dhoni and I would cancel ad shoots to join CSK camp")
        val sportsImages = listOf(
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8)

        val politicsNews = listOf(
            "Maharashtra assembly disrupted as BJP pushes for action",
            "Trump lashes out against foreign actors in new post",
            "Rs 7,000 crore deal for gun systems approved"
        )
        val politicsImages = listOf(
            R.drawable.img_9,
            R.drawable.img_10,
            R.drawable.img_11
        )

        val bollywoodNews = listOf(
            "Bollywood Celebrities Who Worked For Free In Movies",
            "Amitabh Bachchan Beats SRK as Bollywood’s Highest Taxpayer",
            "Bollywood stars tighten contracts to block AI voice"
        )
        val bollywoodImages = listOf(
            R.drawable.img_13,
            R.drawable.img_12,
            R.drawable.img_14
        )

        Row(Modifier.padding(10.dp).horizontalScroll(rememberScrollState())) {

            categories.forEach { category ->
                OutlinedButton(onClick = {
                    selectedCategory = category
                }, Modifier.padding(horizontal = 5.dp),
                    colors = androidx.compose.material3.ButtonDefaults.outlinedButtonColors(
                        containerColor = if (selectedCategory == category) MaterialTheme.colorScheme.primary else Color.Transparent,
                        contentColor = if (selectedCategory == category) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(category)
                }
            }
        }

        Row(Modifier.fillMaxSize()) {
            LazyColumn(Modifier.fillMaxSize().padding(10.dp)) {

                fun listOfData(news: List<String>, img: List<Int>) {
                    items(news.zip(img)) { (text, url) ->
                        Card(modifier = Modifier.fillMaxWidth().padding(5.dp),
                            border = BorderStroke(0.1.dp, MaterialTheme.colorScheme.primary)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(painter = painterResource(url) , "News Image",
                                    modifier = Modifier.fillMaxHeight().width(150.dp))
                                Text(text, Modifier.padding(10.dp))
                            }
                        }
                    }
                }

                when(selectedCategory) {
                    "Technology" -> listOfData(technologyNews, technologyImages)
                    "Business" -> listOfData(businessNews, businessImages)
                    "Politics" -> listOfData(politicsNews, politicsImages)
                    "Sports" -> listOfData(sportsNews, sportsImages)
                    "Bollywood" -> listOfData(bollywoodNews, bollywoodImages)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun News() {
    val activity = LocalActivity.current
    Scaffold(topBar = {
        TopAppBar(title = { Text("News") },
            navigationIcon = {
                IconButton(onClick = {
                    activity?.finish()
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Exit")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Search, "Search")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Notifications, "Notifications")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Settings, "Settings")
                }
            })
    }) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Data()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsTheme {
        News()
    }
}