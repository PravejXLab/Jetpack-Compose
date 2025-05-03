package com.component.flashlight

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.component.flashlight.ui.theme.FlashlightTheme
import com.component.flashlight.ui.theme.PermissionDialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashlightTheme {
                Flashlight()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Flashlight() {
    var flashlightImage by rememberSaveable { mutableIntStateOf(R.drawable.flashlight_off) }
    var torchOn by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current
    var showDialog by rememberSaveable { mutableStateOf(false) }
    val permission = android.Manifest.permission.CAMERA

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (!isGranted) {
            showDialog = true
        }
    }

    if (showDialog) {
        PermissionDialog(showDialog = {showDialog = false})
    }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(permission)
    }

    val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    val cameraId = cameraManager.cameraIdList.firstOrNull() { id ->
        val characteristics = cameraManager.getCameraCharacteristics(id)
        val flashExist = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        val isFlashBack = characteristics.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_BACK
        flashExist && isFlashBack
    }

    if (torchOn) {
        flashlightImage = R.drawable.flashlight_on
        torchOn = true
        cameraId?.let {
            cameraManager.setTorchMode(it, true)
        }
    } else {
        flashlightImage = R.drawable.flashlight_off
        cameraId?.let {
            cameraManager.setTorchMode(it, false)
        }
    }

    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(flashlightImage),
            contentDescription = if (torchOn) "Turn off Flashlight" else "Turn on Flashlight",
            modifier = Modifier.fillMaxSize().padding(16.dp)
        )
        Switch(
            checked = torchOn,
            onCheckedChange = {
                if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
                    torchOn = it
                } else {
                    permissionLauncher.launch(permission)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-64).dp)
        )
    }
}