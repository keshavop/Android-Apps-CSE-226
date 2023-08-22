package com.example.servicedemo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings

class UnboundService : Service(){
    lateinit var mp: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mp.start()
        mp.isLooping = true
        return START_STICKY
    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
    }


    override fun onBind(p0: Intent?): IBinder? {
//        TODO("Not yet implemented")
    return null;
    }

}