package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect XML views to Kotlin code
        val redInput = findViewById<TextInputEditText>(R.id.redChannelInput)
        val greenInput = findViewById<TextInputEditText>(R.id.greenChannelInput)
        val blueInput = findViewById<TextInputEditText>(R.id.blueChannelInput)
        val button = findViewById<Button>(R.id.createColorButton)
        val colorPanel = findViewById<TextView>(R.id.colorPanel)

        // When button is clicked
        button.setOnClickListener {
            val red = redInput.text.toString().trim()
            val green = greenInput.text.toString().trim()
            val blue = blueInput.text.toString().trim()

            if (isValidHex(red) && isValidHex(green) && isValidHex(blue)) {
                val hexColor = "#$red$green$blue"
                try {
                    // Set the background to the new color
                    colorPanel.setBackgroundColor(Color.parseColor(hexColor))
                    colorPanel.text = "Created color display panel"
                } catch (e: IllegalArgumentException) {
                    Toast.makeText(this, "Invalid color format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter valid 2-digit hex values", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to validate if input is 2-digit hex
    private fun isValidHex(value: String): Boolean {
        return value.matches(Regex("^[0-9A-Fa-f]{2}$"))
    }
}