package com.example.gameaing.page

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.gameaing.data.CardViewData
import com.example.gameaing.R
import com.example.gameaing.adapter.ViewPagerAdapter

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val gameList = listOf(
            CardViewData(R.color.simon, R.drawable.logo_simon, R.drawable.simon_text),
            CardViewData(R.color.purple_500, R.drawable.logo1, R.drawable.simon_text),
            CardViewData(R.color.teal_200, R.drawable.logo_dashboard, R.drawable.simon_text), )
        val viewPager2 = findViewById<ViewPager2>(R.id.vpGame)
        val adapter = ViewPagerAdapter(gameList)
        viewPager2.adapter =adapter

    }

}