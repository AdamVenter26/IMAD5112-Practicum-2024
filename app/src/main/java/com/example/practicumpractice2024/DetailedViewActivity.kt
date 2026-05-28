package com.example.practicumpractice2024

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val txtResults = findViewById<TextView>(R.id.txtResults)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Get arrays from previous screen
        val days = intent.getStringArrayExtra("days")
        val morning = intent.getIntArrayExtra("morning")
        val afternoon = intent.getIntArrayExtra("afternoon")

        var results = ""
        var total = 0

        // Loop through arrays
        for (i in 0 until days!!.size) {

            val dailyTotal = morning!![i] + afternoon!![i]

            results = results +
                    days[i] + "\n" +
                    "Morning: " + morning[i] + "\n" +
                    "Afternoon: " + afternoon[i] + "\n" +
                    "Daily Total: " + dailyTotal + "\n\n"

            total = total + dailyTotal
        }

        // Calculate average
        val average = total / days.size

        // Display totals
        results = results +
                "Weekly Total: " + total + "\n" +
                "Average: " + average

        txtResults.text = results

        // Back button
        btnBack.setOnClickListener {

            finish()

        }
    }
}