package com.example.tictactoe

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import com.example.tictactoe.MainActivity.Player



class MainActivity : AppCompatActivity() {

    enum class Player{
        ONE, TWO
    }

    var gameOver = false

    var currentPlayer: Player = Player.ONE
    var gameBoard = arrayOfNulls<Player>(9)

    var winnerRowsColumns = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )


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
//        val tiTag = Integer.parseInt(img.getTag().toString())
        Log.i("TESTY", img.getTag().toString())
        if (gameBoard[Integer.parseInt(img.getTag().toString())] == null && gameOver == false){

            gameBoard[Integer.parseInt(img.getTag().toString()) ] = currentPlayer

            val pvhX = PropertyValuesHolder.ofFloat("translationX", -400f, 0f)
            val alphaVal = PropertyValuesHolder.ofFloat("alpha", 1.0f)
            val rotation = PropertyValuesHolder.ofFloat("rotation" , 360f)
            ObjectAnimator.ofPropertyValuesHolder( img, pvhX, alphaVal, rotation ).apply {
                duration = 1100
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

        checkWinCondition(img, currentPlayer)
    }

    private fun checkWinCondition(img: ImageView, currentPlayer: MainActivity.Player) {


        for ( winnerColumns in winnerRowsColumns){
            if (gameBoard[winnerColumns[0]] ==
                gameBoard[winnerColumns[1]]
                && gameBoard[winnerColumns[1]]
                == gameBoard[winnerColumns[2]] && gameBoard[winnerColumns[0]] != null){

                gameOver = true

                Toast.makeText(this, "WINNER", Toast.LENGTH_SHORT).show()
            }
        }


    }

}

