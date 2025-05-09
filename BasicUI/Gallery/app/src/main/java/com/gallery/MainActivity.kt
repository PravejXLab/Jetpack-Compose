package com.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gallery.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalleryTheme {
                GreedOption()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar( title = {
        Text("Gallery")
    })
}

@Composable
fun Gallery(gridCell: Int) {
    val listOfFruits by remember { mutableStateOf(listOf(
        R.drawable.fruit1,
        R.drawable.fruit2,
        R.drawable.fruit3,
        R.drawable.fruit4,
        R.drawable.fruit5,
        R.drawable.fruit6,
        R.drawable.fruit7,
        R.drawable.fruit8,
        R.drawable.fruit9,
        R.drawable.fruit10,
        R.drawable.fruit11,
        R.drawable.fruit12,
        R.drawable.fruit13,
        R.drawable.fruit14,
        R.drawable.fruit15,
        R.drawable.fruit16,
        R.drawable.fruit17,
        R.drawable.fruit18,
        R.drawable.fruit19,
        R.drawable.fruit20,
        R.drawable.fruit21,
        R.drawable.fruit22,
        R.drawable.fruit23,
        R.drawable.fruit24,
        R.drawable.fruit25,
        R.drawable.fruit26,
        R.drawable.fruit27,
        R.drawable.fruit28,
        R.drawable.fruit29,
        R.drawable.fruit30,
        R.drawable.fruit31,
        R.drawable.fruit32,
        R.drawable.fruit33,
        R.drawable.fruit34,
        R.drawable.fruit35,
        R.drawable.fruit36,
        R.drawable.fruit37,
        R.drawable.fruit38,
        R.drawable.fruit39,
        R.drawable.fruit40,
        R.drawable.fruit41,
        R.drawable.fruit42,
        R.drawable.fruit43,
        R.drawable.fruit44,
        R.drawable.fruit45,
        R.drawable.fruit46,
        R.drawable.fruit47,
        R.drawable.fruit48,
        R.drawable.fruit49,
        R.drawable.fruit50,
        R.drawable.fruit51,
        R.drawable.fruit52,
        R.drawable.fruit53,
        R.drawable.fruit54,
        R.drawable.fruit55,
        R.drawable.fruit56,
        R.drawable.fruit57,
        R.drawable.fruit58,
        R.drawable.fruit59,
        R.drawable.fruit60,
        R.drawable.fruit61,
        R.drawable.fruit62,
        R.drawable.fruit63,
        R.drawable.fruit64,
        R.drawable.fruit65,
        R.drawable.fruit66,
        R.drawable.fruit67,
        R.drawable.fruit68,
        R.drawable.fruit69,
        R.drawable.fruit70,
        R.drawable.fruit71,
        R.drawable.fruit72,
        R.drawable.fruit73,
        R.drawable.fruit74,
        R.drawable.fruit76,
        R.drawable.fruit77,
        R.drawable.fruit78,
        R.drawable.fruit79,
        R.drawable.fruit80,
        R.drawable.fruit81,
        R.drawable.fruit82,
        R.drawable.fruit83,
        R.drawable.fruit84,
        R.drawable.fruit85,
        R.drawable.fruit86,
        R.drawable.fruit87,
        R.drawable.fruit88,
        R.drawable.fruit89,
        R.drawable.fruit90,
        R.drawable.fruit91,
        R.drawable.fruit92,
        R.drawable.fruit93,
        R.drawable.fruit94,
        R.drawable.fruit95,
        R.drawable.fruit96,
        R.drawable.fruit97,
        R.drawable.fruit98,
        R.drawable.fruit99,
        R.drawable.fruit100,
        R.drawable.fruit101,
        R.drawable.fruit102,
        R.drawable.fruit103,
        R.drawable.fruit104,
        R.drawable.fruit105,
        R.drawable.fruit106,
        R.drawable.fruit107,
        R.drawable.fruit108,
        R.drawable.fruit109,
        R.drawable.fruit110,
        R.drawable.fruit111,
        R.drawable.fruit112,
        R.drawable.fruit113,
        R.drawable.fruit114,
        R.drawable.fruit115,
        R.drawable.fruit116,
        R.drawable.fruit117,
        R.drawable.fruit118,
        R.drawable.fruit119,
        R.drawable.fruit120,
        R.drawable.fruit121,
        R.drawable.fruit122,
        R.drawable.fruit123,
        R.drawable.fruit124,
        R.drawable.fruit125,
        R.drawable.fruit126,
        R.drawable.fruit127,
        R.drawable.fruit128,
        R.drawable.fruit129,
        R.drawable.fruit130,
        R.drawable.fruit131,
        R.drawable.fruit132,
        R.drawable.fruit133,
        R.drawable.fruit134,
        R.drawable.fruit135,
        R.drawable.fruit136,
        R.drawable.fruit137,
        R.drawable.fruit138,
        R.drawable.fruit139,
        R.drawable.fruit140,
        R.drawable.fruit141,
        R.drawable.fruit142,
        R.drawable.fruit143,
        R.drawable.fruit144,
        R.drawable.fruit145,
        R.drawable.fruit146,
        R.drawable.fruit147,
        R.drawable.fruit148,
        R.drawable.fruit149,
        R.drawable.fruit150,
        R.drawable.fruit151,
        R.drawable.fruit152,
        R.drawable.fruit153,
        R.drawable.fruit154,
        R.drawable.fruit155,
        R.drawable.fruit156,
        R.drawable.fruit157,
        R.drawable.fruit158,
        R.drawable.fruit159,
        R.drawable.fruit160,
        R.drawable.fruit161,
        R.drawable.fruit162,
        R.drawable.fruit163
    )) }
    var isInFullScreen by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableIntStateOf(R.drawable.fruit1) }

    LazyVerticalGrid(GridCells.Fixed(gridCell)) {
        items(listOfFruits, key = { it }) {item ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
                        isInFullScreen = true
                        selectedItem = item
                    },
                border = BorderStroke(1.dp, Color.Green)
            ) {
                Image(painter = painterResource(item),
                    contentDescription = "Fruits",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                )
            }
        }
    }

    if (isInFullScreen) {
        Dialog(onDismissRequest = { isInFullScreen = false }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(selectedItem),
                        contentDescription = "Fruit",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun GreedOption() {
    var cell by remember { mutableIntStateOf(3) }

    Scaffold(topBar = { TopBar() }) { paddingValues ->
        Column(Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            LazyRow(Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                items(10) { index ->
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(4.dp)) {
                        OutlinedButton(
                            onClick = { cell = index + 1 },
                            shape = CircleShape,
                            border = BorderStroke(1.dp, Color.Green),
                            colors = ButtonDefaults.outlinedButtonColors(
                                if (cell == index + 1) Color.Green else Color.Unspecified),
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("${ index + 1 }",
                                fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }
            Gallery(cell)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GalleryTheme {
        GreedOption()
    }
}