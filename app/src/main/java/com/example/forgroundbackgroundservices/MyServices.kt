package com.example.forgroundbackgroundservices

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import androidx.core.app.NotificationCompat

class MyServices :Service(){

    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString() -> {
                startService()
            }
            Actions.STOP.toString()  -> {
                mediaPlayer.stop()

                stopSelf()

            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startService() {
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        mediaPlayer.start()
        mediaPlayer.isLooping = true

        val notification =NotificationCompat.Builder(this, "Channel 1")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Foreground service")
            .setContentText("Foreground service is running")
            .setOngoing(true)
            .build()
        startForeground(1, notification)
    }
}
enum class Actions {
    START, STOP
}

