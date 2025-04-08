package com.justforfun.fan.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun MyFan(
    modifier: Modifier,
    selectedImage: Int
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center) {
        Image(painter = painterResource(selectedImage),
            contentDescription = "Selected Image",
            modifier = Modifier
                .fillMaxSize())
    }
}