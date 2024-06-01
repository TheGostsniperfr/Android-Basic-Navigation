package fr.thegostsniperfr.android_basic_navigation.screens

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.provider.Telephony.Sms
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen() {
    val smsPermissionState = rememberPermissionState(Manifest.permission.RECEIVE_SMS)
    val context = LocalContext.current

    var isReceiverRegistered by remember { mutableStateOf(false) }

    val requestSmsPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted
            if (!isReceiverRegistered) {
                registerSmsReceiver(context)
                isReceiverRegistered = true
            }
        } else {
            // Handle permission denial
        }
    }

    LaunchedEffect(smsPermissionState) {
        if (!smsPermissionState.status.isGranted) {
            requestSmsPermissionLauncher.launch(Manifest.permission.RECEIVE_SMS)
        } else {
            if (!isReceiverRegistered) {
                registerSmsReceiver(context)
                isReceiverRegistered = true
            }
        }
    }
}

private fun registerSmsReceiver(context: Context) {
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Message received", Toast.LENGTH_SHORT).show()
        }
    }
    val filter = IntentFilter().apply { addAction(Sms.Intents.SMS_RECEIVED_ACTION) }
    context.registerReceiver(receiver, filter)
}

