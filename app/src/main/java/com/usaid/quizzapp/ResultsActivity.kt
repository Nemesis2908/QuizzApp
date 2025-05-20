package com.usaid.quizzapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//end of ViewCompat
        //Code goes here
        val tvScore = findViewById<TextView>(R.id.Score)
        val btnExit = findViewById<Button>(R.id.btnexit)
        //code logic
        //get the score from the intent
        val score = intent.getIntExtra("score", 0)
        //display the score in the textview
        btnExit.setOnClickListener {
            finish()
        }
    }//end of onCreate
}//end of ResultActivity