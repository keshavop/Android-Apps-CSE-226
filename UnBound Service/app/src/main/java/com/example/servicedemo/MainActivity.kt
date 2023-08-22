package com.example.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var serviceStart: Button
    lateinit var serviceStop: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serviceStart = findViewById(R.id.button_Start)
        serviceStop = findViewById(R.id.button_Stop)

        serviceStart.setOnClickListener{
            startService(Intent(applicationContext,UnboundService::class.java))
        }

        serviceStop.setOnClickListener{
            stopService(Intent(applicationContext,UnboundService::class.java))
        }
    }
}