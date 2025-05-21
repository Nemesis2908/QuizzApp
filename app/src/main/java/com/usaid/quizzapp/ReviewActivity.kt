package com.usaid.quizzapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//end of ViewCompat
        //code starts here
        val questions = findViewById<TextView>(R.id.edtQuestionReview)
        val correctAnswers = findViewById<TextView>(R.id.edtAnswercorrect)
        val btnNext = findViewById<Button>(R.id.btnreviewNext)

        val hisQuestions = arrayOf(
            "Rome is known as the eternal city",
            "World war 2 ended in 1954",
            "Nelson Mandela was the first black president of South Africa",
            "Humans were responsible for the extinction of the dinosaurs",
            "The Great Pyramid of Giza is the only one of the ancient Wonders of the World that still stands")
        val correctAnswer = arrayOf(
            "True",
            "False",
            "True",
            "False",
            "True")
    }//end od onCreate
}//end of ReviewActivity