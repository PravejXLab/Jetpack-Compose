package com.neo.tools.calculator.date_difference

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
import androidx.compose.ui.res.painterResource
import com.neo.tools.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDateDifference(onClick: () -> Unit) {
    var visibility by rememberSaveable { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = {
            Text("Date difference")
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
                            R.drawable.visibilityoff
                        } else {
                            R.drawable.visibility
                        }
                    ),
                    contentDescription = "Show more data"
                )
            }
        }
    )
}