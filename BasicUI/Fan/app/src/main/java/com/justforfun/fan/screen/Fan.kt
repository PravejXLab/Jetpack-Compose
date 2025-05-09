package com.justforfun.fan.screen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.justforfun.fan.R
import com.justforfun.fan.components.ListOfFans
import com.justforfun.fan.components.MyFan
import com.justforfun.fan.components.TopBar
import com.justforfun.fan.components.Control

@Preview
@Composable
fun Fan() {
    var selectedImage by remember { mutableIntStateOf(R.drawable.fan1) }
    var isRotating by remember { mutableStateOf(false) }
    var value by remember { mutableFloatStateOf(1f) }
    val infiniteTransition = rememberInfiniteTransition()

    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f * value,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)
        )
    )

    val images by remember { mutableStateOf(listOf(
        R.drawable.fan1,
        R.drawable.fan2,
        R.drawable.fan3,
        R.drawable.fan4,
        R.drawable.fan5,
    )) }

    Scaffold(topBar = { TopBar() }) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val (one, two, three) = createRefs()
            createVerticalChain(one, two, three)

            ListOfFans(
                modifier = Modifier
                    .constrainAs(one) {
                        top.linkTo(parent.top)
                    },
                images = images,
                selectedImage = { selectedImage = it }
            )

            MyFan(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .graphicsLayer { if(isRotating) rotationZ = rotate }
                    .constrainAs(two) {
                        top.linkTo(one.bottom)
                        bottom.linkTo(parent.bottom)
                    },
                selectedImage = selectedImage
            )

            Control(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(three) {
                        top.linkTo(two.bottom)
                        bottom.linkTo(parent.bottom)
                    },
                isRotating = isRotating,
                isRotatingToggle = { isRotating = !isRotating },
                value = value,
                onValueChange = { value = it }
            )
        }
    }
}