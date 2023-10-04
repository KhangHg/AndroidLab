package com.example.diceroller.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(R.id.textView)
            rollDice(R.id.textView2)
            
        }
    }

    private fun rollDice(idTextView:Int) {
        val dice = Dice(6)
        val diceRol = dice.roll()
        val  resultTextView: TextView = findViewById(idTextView)
        resultTextView.text = diceRol.toString()
    }

    class Dice(val numSides: Int){
        fun roll(): Int{
            return (1..numSides).random()
        }
    }
}