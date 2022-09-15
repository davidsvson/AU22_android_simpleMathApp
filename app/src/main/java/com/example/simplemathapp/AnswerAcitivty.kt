package com.example.simplemathapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class AnswerAcitivty : AppCompatActivity() {

    lateinit var resultTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_acitivty)

        resultTextView = findViewById(R.id.resultView)

        val answer = intent.getBooleanExtra("answeredCorrect" , false)
        //Log.d("!!!", "Rätt? $answer")

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