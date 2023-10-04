package com.example.diceroller.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
//            rollDice(R.id.textView)
//            rollDice(R.id.textView2)
            rollDice()
        }

        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
//        val  resultTextView: TextView = findViewById(idTextView)
//        resultTextView.text = diceRol.toString()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int){
        fun roll(): Int{
            return (1..numSides).random()
        }
    }
}