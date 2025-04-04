package com.example.SpeedApp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencing UI elements
        val speedInput: EditText = findViewById(R.id.speedInput)
        val speedCheck: Button = findViewById(R.id.speedCheck)
        val resultText: TextView = findViewById(R.id.resultText)

        // Error handling by reinforcing the user to enter input
        speedCheck.setOnClickListener {
            val speedString = speedInput.text.toString()

            if (speedString.isEmpty()) {
                Toast.makeText(this, "Please enter your speed", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Make sure the user enters the correct input
            val speed = speedString.toIntOrNull()

            if (speed == null || speed < 0) {
                Toast.makeText(this, "Please enter a valid positive number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Checl the speed using if-else logic
            val result: String = when {
                speed < 60 -> "You are driving safely"
                speed in 60..80 -> "Warning! Drive carefully"
                speed in 81..100 -> "Fine: R500"
                else -> "Fine: R2000"
            }

            // Show your results
            resultText.text = result
        }
    }
}