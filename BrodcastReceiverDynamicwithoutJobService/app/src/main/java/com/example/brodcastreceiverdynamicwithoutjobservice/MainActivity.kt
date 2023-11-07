package com.example.brodcastreceiverdynamicwithoutjobservice

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {

    lateinit var receiver: AirplaneModeDemo
//    lateinit var receiver2: WifiChangeModeDemo

    lateinit var wifiSwitch: Switch
    lateinit var wifiManager: WifiManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = AirplaneModeDemo()
//        receiver2 = WifiChangeModeDemo()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also{
            registerReceiver(receiver,it)
        }

//        IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION).also{
//            registerReceiver(receiver2,it)
//        }
        wifiSwitch = findViewById(R.id.switch1)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        wifiSwitch.setOnCheckedChangeListener{compoundButton, isChecked ->
            if (isChecked){
                wifiManager.isWifiEnabled = true
                wifiSwitch.text = "wifi is ON"
            }
            else{
                wifiManager.isWifiEnabled = false
                wifiSwitch.text = "wifi is OFF"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
//        unregisterReceiver(receiver2)
    }
    private val wifiStateReceiver:BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
        when(p1!!.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN)){
         WifiManager.WIFI_STATE_ENABLED ->{
             wifiSwitch.isChecked = true
             wifiSwitch.text = "WIFI is ON"
             Toast.makeText(applicationContext,"WIFI IS ON",Toast.LENGTH_SHORT).show()
         }
            WifiManager.WIFI_STATE_DISABLED ->{
                wifiSwitch.isChecked = false
                wifiSwitch.text = "WIFI is OFF"
                Toast.makeText(applicationContext,"WIFI IS OFF",Toast.LENGTH_SHORT).show()
            }
        }
        }
    }
}