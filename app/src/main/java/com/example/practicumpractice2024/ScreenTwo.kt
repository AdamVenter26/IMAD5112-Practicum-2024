package com.example.practicumpractice2024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScreenTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_two)

        val days = arrayOf("Monday", "Tuesday")

        val morningMinutes = IntArray(2)
        val afternoonMinutes = IntArray(2)

        val edtMorning1 = findViewById<EditText>(R.id.edtMorning1)
        val edtAfternoon1 = findViewById<EditText>(R.id.edtAfternoon1)

        val edtMorning2 = findViewById<EditText>(R.id.edtMorning2)
        val edtAfternoon2 = findViewById<EditText>(R.id.edtAfternoon2)

        val btnDetailed = findViewById<Button>(R.id.btnDetailed)
        val btnClear = findViewById<Button>(R.id.btnClear)

        // Clear button
        btnClear.setOnClickListener {

            edtMorning1.text.clear()
            edtAfternoon1.text.clear()

            edtMorning2.text.clear()
            edtAfternoon2.text.clear()

        }

        // View report button
        btnDetailed.setOnClickListener {

            // Validation
            if (edtMorning1.text.toString().isEmpty() ||
                edtAfternoon1.text.toString().isEmpty() ||
                edtMorning2.text.toString().isEmpty() ||
                edtAfternoon2.text.toString().isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please enter all values",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                // Store values into arrays
                morningMinutes[0] = edtMorning1.text.toString().toInt()
                afternoonMinutes[0] = edtAfternoon1.text.toString().toInt()

                morningMinutes[1] = edtMorning2.text.toString().toInt()
                afternoonMinutes[1] = edtAfternoon2.text.toString().toInt()

                // Move to next screen
                val intent = Intent(
                    this,
                    DetailedViewActivity::class.java
                )

                intent.putExtra("days", days)
                intent.putExtra("morning", morningMinutes)
                intent.putExtra("afternoon", afternoonMinutes)

                startActivity(intent)
            }
        }
    }
}