package com.example.tictactoe

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    enum class Player{
        ONE, TWO
    }

    var currentPlayer: Player = Player.ONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val clickListener = View.OnClickListener { view ->

            when (view.getId()){
                R.id.img1 -> img1ClickAction(img1)
                R.id.img2 -> img1ClickAction(img2)
                R.id.img3 -> img1ClickAction(img3)
                R.id.img4 -> img1ClickAction(img4)
                R.id.img5 -> img1ClickAction(img5)
                R.id.img6 -> img1ClickAction(img6)
                R.id.img7 -> img1ClickAction(img7)
                R.id.img8 -> img1ClickAction(img8)
                R.id.img9 -> img1ClickAction(img9)
                }
            }

            // TODO create a function to select all ImageViews in an Activity
            img1.setOnClickListener(clickListener)
            img2.setOnClickListener(clickListener)
            img3.setOnClickListener(clickListener)
            img4.setOnClickListener(clickListener)
            img5.setOnClickListener(clickListener)
            img6.setOnClickListener(clickListener)
            img7.setOnClickListener(clickListener)
            img8.setOnClickListener(clickListener)
            img9.setOnClickListener(clickListener)
        }

    private fun img1ClickAction(img: ImageView) {
        val pvhX = PropertyValuesHolder.ofFloat("translationX", -400f, 0f)
        val alphaVal = PropertyValuesHolder.ofFloat("alpha", 1.0f)
        val rotation = PropertyValuesHolder.ofFloat("rotation" , 360f)
        ObjectAnimator.ofPropertyValuesHolder( img, pvhX, alphaVal, rotation ).apply {
            duration = 1500
            start()
        }
        if (currentPlayer == Player.ONE){
            img.setImageResource(R.drawable.x_img)
            currentPlayer = Player.TWO
        }else {
            img.setImageResource(R.drawable.circle_img)
            currentPlayer = Player.ONE
        }

    }
}

