package com.example.brodcastreceiverjobservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class BrodcastReceiverDemo:BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        var mp = MediaPlayer.create(context, R.raw.ring)
        Log.d("Hello","repeating alarm")
        mp.start()
        Toast.makeText(context,"Message",Toast.LENGTH_SHORT).show()
    }
}