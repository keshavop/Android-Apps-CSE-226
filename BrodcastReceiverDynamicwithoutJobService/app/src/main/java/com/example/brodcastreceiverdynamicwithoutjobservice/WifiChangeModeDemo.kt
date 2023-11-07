package com.example.brodcastreceiverdynamicwithoutjobservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class WifiChangeModeDemo: BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        val isAirplaneModeEnabled = p1?.getBooleanExtra("state",false)?:return
        if(isAirplaneModeEnabled){
            Toast.makeText(p0,"Wifi Mode Enabled", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(p0,"Wifi Mode not Enabled", Toast.LENGTH_SHORT).show()
        }
    }
}