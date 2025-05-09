package com.progress.illusion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AppList(appName: String, checked: Boolean, navController: NavController, route: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(Modifier.weight(1f)) {
            TextButton(onClick = { navController.navigate(route)}, contentPadding = PaddingValues(0.dp), modifier = Modifier.padding(0.dp).defaultMinSize(0.dp, 0.dp).height(30.dp)) {
                Text(appName)
            }
        }
        Checkbox(checked = checked, onCheckedChange = {}, Modifier.size(20.dp))
    }
}