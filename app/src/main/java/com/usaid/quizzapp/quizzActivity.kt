package com.usaid.quizzapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quizzActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//end of ViewCompat
        //code starts here
        val tvQuestion = findViewById<TextView>(R.id.QuizzQuestions)
        val rbtnAnswers = findViewById<RadioGroup>(R.id.rbtnQuizzAnswer)
        val btnNext = findViewById<Button>(R.id.btnNext)
        //Arrays of Questions and Answers
        val historyQuestions = arrayOf(
            "Rome is known as the eternal city",
            "World war 2 ended in 1954",
            "Nelson Mandela was the first black president of South Africa",
            "Humans were responsible for the extinction of the dinosaurs",
            "The Great Pyramid of Giza is the only one of the ancient Wonders of the World that still stands")
        var userAnswers = arrayOfNulls<String>(5)
        val correctAnswers = arrayOf(
            "True",
            "False",
            "True",
            "False",
            "True")
        var counter = 0
        //code logic
        tvQuestion.text = historyQuestions[counter]
        for (i in 0 until rbtnAnswers.childCount) {
            val radioButton = rbtnAnswers.getChildAt(i) as RadioButton}

        btnNext.setOnClickListener {
            if (counter < 5) {
                var selectedOption = rbtnAnswers.checkedRadioButtonId

                if (selectedOption != -1) {
                    val selectedRbtn = findViewById<RadioButton>(selectedOption)
                    userAnswers[counter] = selectedRbtn.text.toString()
                    counter++
                } else {
                    Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
            }
                if (counter < 5) {
                    tvQuestion.text = historyQuestions[counter]
                    for (i in 0 until rbtnAnswers.childCount) {
                        val radioButton = rbtnAnswers.getChildAt(i) as RadioButton
                    }
                    rbtnAnswers.clearCheck()
                } else {
                    val intent = Intent(this, ResultsActivity::class.java)
                    var score = 0

                    // Calculate score
                    for (i in userAnswers.indices) {
                        if (userAnswers[i] == correctAnswers[i]) {
                            score++
                        }
                    }

                    intent.putExtra("score", score)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }//end of onCreate
}//end of QuizActivity