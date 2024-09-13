package com.rpm24.mp3_player_22012011042

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private lateinit var mediaPlayer:MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int{
        if (!this::mediaPlayer.isInitialized)
            mediaPlayer = MediaPlayer.create(this,R.raw.alarm)
        if(intent!=null){
            when (intent.getStringExtra("Service")) {
                "Play" -> {
                    if (!mediaPlayer.isPlaying) {
                        mediaPlayer.start()
                    }
                }
                "Pause" -> {
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.pause()
                    }
                }
            }
            Log.i("Service","onStartCommand")
        }
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }
}