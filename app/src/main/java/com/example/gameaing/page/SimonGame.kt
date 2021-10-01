package com.example.gameaing.page

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.example.gameaing.R
import kotlinx.coroutines.*
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class SimonGame : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    var dataSimon = arrayListOf<Int>()
    var dataUserSimon = arrayListOf<Int>()
    val dataButton = arrayListOf(R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4)
    var level  = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simon_game)
            val simonList = arrayOf(1, 2, 3, 4)
            val scoreText = findViewById<TextView>(R.id.tvScore)
            val btn1 = findViewById<Button>(R.id.btn1)
            val btn2 = findViewById<Button>(R.id.btn2)
            val btn3 = findViewById<Button>(R.id.btn3)
            val btn4 = findViewById<Button>(R.id.btn4)
            val clFullGame = findViewById<ConstraintLayout>(R.id.clFullGame)
            val tvLose = findViewById<TextView>(R.id.tvLose)
            val tvEndScore = findViewById<TextView>(R.id.tvEndScore)
            val btnStart = findViewById<Button>(R.id.btnStart)
            val audioAnimate = MediaPlayer.create(this,R.raw.sound_animate)
            val audioGame = MediaPlayer.create(this,R.raw.sound_game)
            val audioLose = MediaPlayer.create(this,R.raw.sound_losing)
            audioGame.start()
            audioGame.setVolume(20f,20f)

            btnStart.setOnClickListener{
                lifecycleScope.launch(Dispatchers.Main ){
                    audioGame.stop()
                    clFullGame.visibility = View.VISIBLE
                    tvLose.visibility = View.GONE
                    tvEndScore.visibility = View.GONE
                    btnStart.visibility = View.GONE
                    level = 0
                    scoreText.text = "SCORE : $level"
                    delay(2000L)
                    dataSimon = arrayListOf()
                    dataUserSimon = arrayListOf()
                    level = 0
                    startGame()
                    playingSimon()
                }

            }

        btn1.setOnClickListener {
            Log.d("MyActivity","Button terClick")
                dataUserSimon.add(0)
            audioAnimate.start()
            Log.d("MyActivity",dataUserSimon.toString() + dataSimon.toString())
            lifecycleScope.launch(Dispatchers.Main){
                if(dataUserSimon[dataUserSimon.size-1]!= dataSimon[dataUserSimon.size-1]){
                    tvEndScore.text = "Your Score : ${level.toString()}"
                    tvLose.visibility = View.VISIBLE
                    tvEndScore.visibility = View.VISIBLE
                    btnStart.visibility = View.VISIBLE
                    clFullGame.visibility = View.GONE
                    btnStart.text = "Start Again"
                    audioLose.start()
                    dataSimon = arrayListOf()
                    dataUserSimon = arrayListOf()
                    level = 0
                    startGame()
                }else if(dataUserSimon.size == dataSimon.size){
                    level+=1
                    scoreText.text = "SCORE : $level"
                    delay(500L)
                    playingSimon()
                }

            }



        }
        btn2.setOnClickListener {
            Log.d("MyActivity","Button terClick")

                dataUserSimon.add(1)
            audioAnimate.start()
            Log.d("MyActivity",dataUserSimon.toString() + dataSimon.toString())
            lifecycleScope.launch(Dispatchers.Main){
                if(dataUserSimon[dataUserSimon.size-1]!= dataSimon[dataUserSimon.size-1]){
                    tvEndScore.text = "Your Score : ${level.toString()}"
                    tvLose.visibility = View.VISIBLE
                    tvEndScore.visibility = View.VISIBLE
                    btnStart.visibility = View.VISIBLE
                    clFullGame.visibility = View.GONE
                    btnStart.text = "Start Again"
                    audioLose.start()
                    dataSimon = arrayListOf()
                    dataUserSimon = arrayListOf()
                    level = 0
                    startGame()
                }else if(dataUserSimon.size == dataSimon.size){
                    level+=1
                    scoreText.text = "SCORE : $level"
                    delay(500L)
                    playingSimon()
                }

            }



        }
        btn3.setOnClickListener {
            Log.d("MyActivity","Button terClick")


                dataUserSimon.add(2)
            audioAnimate.start()
            Log.d("MyActivity",dataUserSimon.toString() + dataSimon.toString())

            lifecycleScope.launch(Dispatchers.Main){
                if(dataUserSimon[dataUserSimon.size-1]!= dataSimon[dataUserSimon.size-1]){
                    tvEndScore.text = "Your Score : ${level.toString()}"
                    tvLose.visibility = View.VISIBLE
                    tvEndScore.visibility = View.VISIBLE
                    btnStart.visibility = View.VISIBLE
                    clFullGame.visibility = View.GONE
                    btnStart.text = "Start Again"
                    audioLose.start()
                    dataSimon = arrayListOf()
                    dataUserSimon = arrayListOf()
                    level = 0
                    startGame()
                }else if(dataUserSimon.size == dataSimon.size){
                    level+=1
                    scoreText.text = "SCORE : $level"
                    delay(500L)
                    playingSimon()
                }

            }



        }

        btn4.setOnClickListener {
            Log.d("MyActivity","Button terClick")
            dataUserSimon.add(3)
            audioAnimate.start()
            Log.d("MyActivity",dataUserSimon.toString() + dataSimon.toString())
            lifecycleScope.launch(Dispatchers.Main){
                if(dataUserSimon[dataUserSimon.size-1]!= dataSimon[dataUserSimon.size-1]){
                    tvEndScore.text = "Your Score : ${level.toString()}"
                    tvLose.visibility = View.VISIBLE
                    tvEndScore.visibility = View.VISIBLE
                    btnStart.visibility = View.VISIBLE
                    clFullGame.visibility = View.GONE
                    btnStart.text = "Start Again"
                    audioLose.start()
                    dataSimon = arrayListOf()
                    dataUserSimon = arrayListOf()
                    level = 0
                    startGame()
                }else if(dataUserSimon.size == dataSimon.size){
                    level+=1
                    scoreText.text = "SCORE : $level"
                    delay(500L)
                    playingSimon()
                }

            }

        }



    }

    fun startGame(){
        dataSimon = arrayListOf()
        dataUserSimon = arrayListOf()
        level = 0
    }

    suspend fun playingSimon(){
        if(dataSimon.size == 0){
            playAi()
        }else{
            playAi()
        }
        dataUserSimon = arrayListOf()
    }

    @SuppressLint("SetTextI18n")
    suspend fun playAi(){
        val tvScore = findViewById<TextView>(R.id.tvScore)
        val audioAnimate = MediaPlayer.create(this,R.raw.sound_animate)
        val list = listOf(0,1,2,3)
        val random = list.random()
        val randomChosenButton = dataButton[random]
        val btn = findViewById<Button>(randomChosenButton)
        dataSimon.add(random)
        for(i in dataSimon){
            val btnRotate = findViewById<Button>(dataButton[i])
            delay(1000L)
            btnRotate.rotation = 0f
            audioAnimate.start()
            btnRotate.animate().apply {
                rotation(360f)
            }.start()
            delay(500)
        }

   }

}
