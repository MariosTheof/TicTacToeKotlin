package com.example.tictactoe

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



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
                R.id.img1 -> imgClickAction(img1)
                R.id.img2 -> imgClickAction(img2)
                R.id.img3 -> imgClickAction(img3)
                R.id.img4 -> imgClickAction(img4)
                R.id.img5 -> imgClickAction(img5)
                R.id.img6 -> imgClickAction(img6)
                R.id.img7 -> imgClickAction(img7)
                R.id.img8 -> imgClickAction(img8)
                R.id.img9 -> imgClickAction(img9)
                R.id.resetButton -> resetTheGame()
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
            resetButton.setOnClickListener(clickListener)
        }

    /* Actions that happen when player presses a spot in the grid.
    * Animations & change of turns */
    private fun imgClickAction(img: ImageView) {
        if (gameBoard[Integer.parseInt(img.tag.toString())] == null && !gameOver){
            gameBoard[Integer.parseInt(img.tag.toString()) ] = currentPlayer

            val pvhX = PropertyValuesHolder.ofFloat("translationX", -400f, 0f)
            val alphaVal = PropertyValuesHolder.ofFloat("alpha", 1.0f)
            val rotation = PropertyValuesHolder.ofFloat("rotation" , 360f)
            ObjectAnimator.ofPropertyValuesHolder( img, pvhX, alphaVal, rotation ).apply {
                duration = 1100
                start()
            }

            if(currentPlayer == Player.ONE){
                img.setImageResource(R.drawable.x_img)
                currentPlayer = Player.TWO
            } else {
                img.setImageResource(R.drawable.circle_img)
                currentPlayer = Player.ONE
            }
        }

        checkWinCondition(img)
    }

    /* Checks if one symbol has completed a row or a column */
    private fun checkWinCondition(img: ImageView) {
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

    /* Reset Game Function */
    private fun resetTheGame() {

        for (index in 0 until gridLayout.childCount) {

            val imageView = gridLayout.getChildAt(index) as ImageView
            imageView.setImageDrawable(null)
            imageView.alpha = 0.2f
        }

        currentPlayer = Player.ONE
        gameBoard[0] = null
        gameBoard[1] = null
        gameBoard[2] = null
        gameBoard[3] = null
        gameBoard[4] = null
        gameBoard[5] = null
        gameBoard[6] = null
        gameBoard[7] = null
        gameBoard[8] = null


        gameOver = false

    }

}

