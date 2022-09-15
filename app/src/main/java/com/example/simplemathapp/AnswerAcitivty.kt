package com.example.simplemathapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class AnswerAcitivty : AppCompatActivity() {

    lateinit var resultTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_acitivty)

        resultTextView = findViewById(R.id.resultView)

        val answer = intent.getBooleanExtra("answeredCorrect" , false)
        val score = intent.getIntExtra("score", 0)
        val button = findViewById<Button>(R.id.backButton)

        button.setOnClickListener {
            finish()
        }


//        if (answer ) {
//            resultTextView.text = "Rätt svar"
//        } else {
//            resultTextView.text = "Fel svar"
//        }

        resultTextView.text = if (answer) {
            "Rätt svar"
        } else {
            "Fel svar"
        }

    }
}

// tillbaka knapp
// räkna poäng
// byta bakgrund om det blir rätt eller fel
// skicka rätt svar till answer activity
// fler räknesätt än bara + ( eventuellt med en startmeny där man väljer räknesätt)
//
