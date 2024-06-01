package fr.thegostsniperfr.android_basic_navigation.screens

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import fr.thegostsniperfr.android_basic_navigation.broadcast.SystemBroadcastReceiver

@Composable
fun HomeScreen (
    onBluetoothStateChange: () -> Unit
){
    SystemBroadcastReceiver(systemAction = BluetoothAdapter.ACTION_STATE_CHANGED) { receiveIntent ->
        val action = receiveIntent?.action?: return@SystemBroadcastReceiver
        if(action == BluetoothAdapter.ACTION_STATE_CHANGED) {
            onBluetoothStateChange()
        }
    }
}