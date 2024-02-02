package com.example.diceroller2

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var randomButton: Button
    private lateinit var setToRandom: Button
    private lateinit var diceImage: ImageView
    private lateinit var diceRollSound: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomButton = findViewById(R.id.button)
        setToRandom = findViewById(R.id.button2)
        diceImage = findViewById(R.id.imageView)
        diceRollSound = MediaPlayer.create(this, R.raw.dicesound)

        randomButton.setOnClickListener {
            // Play the dice roll sound
            diceRollSound.start()

            // Generate random number for dice roll
            val random = (1..6).random()

            // Set dice image based on the random number
            val drawable = when (random) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_random
            }

            // Set the dice image
            diceImage.setImageResource(drawable)
        }

        setToRandom.setOnClickListener {
            // Play the dice roll sound
            diceRollSound.start()

            // Set the dice image to random
            diceImage.setImageResource(R.drawable.dice_random)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        diceRollSound.release()
    }
}
