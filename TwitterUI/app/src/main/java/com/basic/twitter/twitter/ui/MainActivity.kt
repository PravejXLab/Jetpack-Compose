package com.basic.twitter.twitter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basic.twitter.twitter.ui.ui.theme.TwitterUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwitterUITheme {
                Twitter()

            }
        }
    }
}

@Composable
fun InteractPrimary(image: Painter, text: String, modifier: Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(image, "Comment",
            modifier = Modifier.size(15.dp))
        Spacer(modifier = Modifier.width(2.dp))
        Text(text, fontSize = 12.sp)
    }
}

@Composable
fun Primary() {
    Row(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(R.drawable.gwr),
            contentDescription = "Logo",
            modifier = Modifier.size(40.dp)
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Guinness World Record ", fontWeight = FontWeight.Bold)
                Image(
                    painterResource(R.drawable.bedge), "Verified Bedge",
                    modifier = Modifier.size(15.dp)
                )
                Text("  @G...", modifier = Modifier.weight(1f))
                Icon(Icons.Default.MoreVert, "Options")
            }
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(
                    "Longest duration holding Hercules pillars (male) 💪⏱️ 2 mins 10.75 seconds by",
                    fontSize = 14.sp
                )
                Text("@VispyKharadi", color = Color.Blue, fontSize = 14.sp)
            }
            Card(modifier = Modifier.fillMaxWidth().aspectRatio(1f).padding(10.dp)) {
                Image(
                    painterResource(R.drawable.gwr), "Photo",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                InteractPrimary(
                    painterResource(R.drawable.comment),
                    "1.8K",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                InteractPrimary(
                    painterResource(R.drawable.retweet),
                    "11.1K",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                InteractPrimary(
                    painterResource(R.drawable.graph),
                    "14.5M",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                InteractPrimary(
                    painterResource(R.drawable.like),
                    "86.7K",
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.align(Alignment.CenterStart)) {
                        Image(painterResource(R.drawable.shave), "Comment",
                            modifier = Modifier.size(15.dp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.align(Alignment.CenterEnd)) {
                        Image(painterResource(R.drawable.share), "Comment",
                            modifier = Modifier.size(15.dp))
                    }
                }
            }

        }
    }
}

@Composable
fun Secondary() {
    Row(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(R.drawable.musk),
            contentDescription = "Logo",
            modifier = Modifier.size(40.dp)
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Elon Musk ", fontWeight = FontWeight.Bold)
                
                Text(" @elonmusk .6h", modifier = Modifier.weight(1f))
                Icon(Icons.Default.MoreVert, "Options")
            }
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(
                    """Elon Reeve Musk FRS is a business magnate and investor. He is the founder, CEO and chief engineer of SpaceX.
                        |Angel investor, CEO and product architect of Tesla, Inc. Owner and CEO of Twitter, Inc.
                        |Founder of The Boring Company and co-founder of Neuralink and OpenAI""".trimMargin(),
                    fontSize = 14.sp
                )
            }
            Card(modifier = Modifier.fillMaxWidth().padding(10.dp).wrapContentSize()) {
                Image(
                    painterResource(R.drawable.elon), "Photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                InteractPrimary(
                    painterResource(R.drawable.comment),
                    "11.6K",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                InteractPrimary(
                    painterResource(R.drawable.retweet),
                    "36.8K",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                InteractPrimary(
                    painterResource(R.drawable.graph),
                    "56.3M",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                InteractPrimary(
                    painterResource(R.drawable.like),
                    "5.3M",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.align(Alignment.CenterStart)) {
                        Image(painterResource(R.drawable.shave), "Comment",
                            modifier = Modifier.size(15.dp))
                    }
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.align(Alignment.CenterEnd)) {
                        Image(painterResource(R.drawable.share), "Comment",
                            modifier = Modifier.size(15.dp))
                    }
                }
            }

        }
    }
}

@Composable
fun Twitter() {
    Scaffold { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)) {
            Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Row(modifier = Modifier.weight(1f)) {
                    Image(painter = painterResource(R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier.size(30.dp))
                }
                Row(modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(R.drawable.th),
                        contentDescription = "Profile",
                        modifier = Modifier.size(25.dp))
                }
                Row(modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text("Upgrade", fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterStart))
                    Icon(Icons.Default.MoreVert, "More",
                        modifier = Modifier.align(Alignment.CenterEnd))
                    }
                }
            }
            HorizontalDivider(color = Color.Gray)
            Primary()
            HorizontalDivider(color = Color.Gray)
            Secondary()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TwitterUITheme {
       Twitter()

    }
}