package com.neo.tools.basic_tools.Flashlight

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import com.neo.tools.R


@Preview(showBackground = true)
@Composable
fun Flashlight() {
    val context = LocalContext.current
    var flashlight by rememberSaveable { mutableIntStateOf(R.drawable.flashlight_off) }
    var checked by rememberSaveable { mutableStateOf(false) }
    var showDialog by rememberSaveable { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (!isGranted) {
            checked = false
            showDialog = true
        }
    }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.CAMERA)
    }

    if (showDialog) {
        ErrorDialog(cancel = {showDialog = false})
    }

    val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    val cameraId = cameraManager.cameraIdList.firstOrNull() { id ->
        val characteristics = cameraManager.getCameraCharacteristics(id)
        val isFlash = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        val isBack = characteristics.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_BACK
        isFlash && isBack
    }

    if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
        if (checked) {
            flashlight = R.drawable.flashlight_on

            cameraId?.let {
                cameraManager.setTorchMode(it, true)
            }

        } else {
            flashlight = R.drawable.flashlight_off

            cameraId?.let {
                cameraManager.setTorchMode(it, false)
            }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 64.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(flashlight),
            contentDescription = "Flashlight is off!"
        )
        Switch(
            modifier = Modifier.align(Alignment.BottomCenter),
            checked = checked,
            onCheckedChange = {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    permissionLauncher.launch(Manifest.permission.CAMERA)
                } else {
                    checked = it
                }
            }
        )
    }
}

@Composable
fun ErrorDialog(cancel: () -> Unit) {
    Dialog(onDismissRequest = cancel) {
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Warning",
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
                Row(Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(
                        text = "Camera permission is required for the flashlight to work, please allow permission from setting!",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = cancel) {
                        Text("Cancel")
                    }
                    TextButton(onClick = cancel) {
                        Text("Setting")
                    }
                }
            }
        }
    }
}

