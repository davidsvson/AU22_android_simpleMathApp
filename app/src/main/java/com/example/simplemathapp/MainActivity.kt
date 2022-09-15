package com.example.simplemathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var questionTextView : TextView
    lateinit var answerView : EditText
    var correctAnswer : Int = 0
    var score : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        answerView = findViewById(R.id.answerView)

        val button = findViewById<Button>(R.id.answerButton)

        button.setOnClickListener {
            handleButtonPress()
        }

        setNewQuestion()
    }

    override fun onRestart() {
        super.onRestart()

        answerView.setText("")
        setNewQuestion()

    }

    fun handleButtonPress() {

        val answeredCorrect = checkAnswer()
        if (answeredCorrect) {
            score++
        }
        Log.d("!!!", "Du svarade $answeredCorrect")
        val intent = Intent(this, AnswerAcitivty::class.java)
        intent.putExtra("answeredCorrect", answeredCorrect)
        intent.putExtra("score", score)

        startActivity(intent)
    }

    fun checkAnswer() : Boolean {
        // kolla vad användaren svarar
        val answerText = answerView.text.toString()
        val answer = answerText.toIntOrNull()

        // jämför användarens svar med rätta svaret och returnera
        return answer == correctAnswer
    }


    fun setNewQuestion() {

        var firstNumber = (1..10).random()
        var secondNumber = (1..10).random()

        correctAnswer = firstNumber + secondNumber
        questionTextView.text = "$firstNumber + $secondNumber"
    }


}