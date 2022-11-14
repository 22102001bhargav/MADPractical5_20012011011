package com.example.madPractical5_20012011011

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.madPractical5_20012011011.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppbar)

        val bPlay = findViewById<FloatingActionButton>(R.id.playButton)
        val bStop = findViewById<FloatingActionButton>(R.id.stopButton)

        bPlay.setOnClickListener{
            play()
        }
        bStop.setOnClickListener{
            stop()
        }
    }

     fun play(){
        Intent(applicationContext,MediaService::class.java).putExtra(MediaService.DATA_KEY,MediaService.DATA_VALUE).apply {
            startService(this)
        }
    }

    fun stop(){
        Intent(applicationContext,MediaService::class.java).apply {
            stopService(this)
        }
    }
}