package com.example.gameaing.page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.gameaing.R
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val logoku = findViewById<ImageView>(R.id.ivLogo)
        val tvZatel = findViewById<TextView>(R.id.tvZatel)

        Handler().postDelayed({
            Intent(this, Dashboard :: class.java).also {
                startActivity(it)
                finish()
            }
        },3000L)

    }
}