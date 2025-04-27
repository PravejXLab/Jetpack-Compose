package com.neo.tools.calculator.age

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.neo.tools.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarAge(onClick: () -> Unit) {
    var visibility by rememberSaveable { mutableStateOf(true) }

    CenterAlignedTopAppBar(
        title = {
            Text("Age Calculator")
        },
        navigationIcon = {
            IconButton(
                onClick = { onClick() }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Exit")
            }
        },
        actions = {
            IconButton(
                onClick = { visibility = !visibility }
            ) {
                Icon(
                    painter = painterResource(
                        if (visibility) {
                            R.drawable.visibility
                        } else {
                            R.drawable.visibilityoff
                        }
                    ),
                    contentDescription = null
                )
            }
        }
    )
}