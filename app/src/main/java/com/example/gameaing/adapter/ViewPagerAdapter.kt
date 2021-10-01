package com.example.gameaing.adapter

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.gameaing.data.CardViewData
import com.example.gameaing.R
import com.example.gameaing.page.Dashboard
import com.example.gameaing.page.SimonGame

class ViewPagerAdapter(val games : List<CardViewData>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolderView>() {

    inner class ViewHolderView(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_game_menu,parent,false)
        return ViewHolderView(view)
    }

    override fun onBindViewHolder(holder: ViewHolderView, position: Int) {
        val curGames = games[position]
        holder.itemView.apply {
            val llGames = findViewById<LinearLayout>(R.id.llGames)
            val ivLogo = findViewById<ImageView>(R.id.ivLogo)
            val ivText = findViewById<ImageView>(R.id.ivText)
            val cvGamess = findViewById<CardView>(R.id.cvGames)
            llGames.setBackgroundResource(curGames.backgroundColor)
            ivLogo.setImageResource(curGames.logo)
            ivText.setImageResource(curGames.text)

            cvGamess.setOnClickListener {
                when (position) {
                    0 -> {
                        Intent(context, SimonGame::class.java).also {
                            startActivity(context, it, Bundle.EMPTY)
                        }
                    }
                    1 -> Toast.makeText(context, "Game kedua belum ada", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(context, "Game ke 3 cooming soon", Toast.LENGTH_SHORT)
                        .show()


                }
            }

        }
    }

    override fun getItemCount(): Int {

        return  games.size
    }
}