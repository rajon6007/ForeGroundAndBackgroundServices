package com.example.forgroundbackgroundservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 100)

        findViewById<Button>(R.id.start).setOnClickListener {
            val intent =Intent(this, MyServices::class.java)
            intent.action = Actions.START.toString()
            startService(intent)
        }
        findViewById<Button>(R.id.stop).setOnClickListener {
            val intent =Intent(this, MyServices::class.java)
            intent.action = Actions.STOP.toString()
            startService(intent)
        }

    }
}