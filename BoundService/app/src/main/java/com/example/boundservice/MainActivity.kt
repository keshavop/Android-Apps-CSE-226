package com.example.boundservice

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var Start:Button
    lateinit var Stop:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Start = findViewById(R.id.start)
        Stop = findViewById(R.id.stop)

        Start.setOnClickListener{
            val intent = Intent(this, Foreground::class.java)
            intent.putExtra("inputExtra", "Foreground Servoce is running")
            ContextCompat.startForegroundService(this, intent)
        }

        Stop.setOnClickListener{
            val intent = Intent(this, Foreground::class.java)
            stopService(intent)
        }
    }
}