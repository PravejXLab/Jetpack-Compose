package com.justforfun.fan.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ListOfFans(
    images: List<Int>,
    modifier: Modifier,
    selectedImage: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier) {
        items(images) { image ->
            Surface(
                border = BorderStroke(1.dp, Color.Gray),
                tonalElevation = 10.dp,
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { selectedImage(image) }
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = "List of Images",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(8.dp)
                )
            }
        }
    }
}