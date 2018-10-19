package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_quiz_navigation.*

class QuizNavigation : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELONE = "Level One"
    private var LEVELTWO = "Level Two"
    private var LEVELTHREE = "Level Three"
    private var LEVELFOUR = "Level Four"
    var acheiveString = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_navigation)
        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
        init();



        var btnQuizLvl = findViewById<Button>(R.id.Btn6)
        btnQuizLvl.setOnClickListener{

            Intent()
            val myIntent = Intent(this, QuizLevel1::class.java)
            startActivity(myIntent)
        }

        var btnQuizLv2 = findViewById<Button>(R.id.Btn7)
        btnQuizLv2.setOnClickListener{

            Intent()
            val myIntent = Intent(this, QuizLevel2::class.java)
            startActivity(myIntent)
        }
        var btnQuizLv3 = findViewById<Button>(R.id.Btn8)
        btnQuizLv3.setOnClickListener{

            Intent()
            val myIntent = Intent(this, QuizLevel3::class.java)
            startActivity(myIntent)
        }
        var btnQuizLv4 = findViewById<Button>(R.id.Btn9)
        btnQuizLv4.setOnClickListener{

            Intent()
            val myIntent = Intent(this, QuizLevel4::class.java)
            startActivity(myIntent)
        }
    }

    fun init(){
        acheiveString = ""
        Btn7.setVisibility(View.VISIBLE);
        Btn8.setVisibility(View.VISIBLE);
        Btn9.setVisibility(View.VISIBLE);
        if(sharedPreferences.getBoolean(LEVELONE, false).equals(true)){
            acheiveString+= LEVELONE + " Completed!\n"
        }
        else{
            acheiveString+= LEVELONE + " Not Completed!\n"
            Btn7.setVisibility(View.GONE);
        }

        if(sharedPreferences.getBoolean(LEVELTWO, false).equals(true)){
            acheiveString+= LEVELTWO + " Completed!\n"
        }
        else{
            acheiveString+= LEVELTWO + " Not Completed!\n"
            Btn8.setVisibility(View.GONE);
        }

        if(sharedPreferences.getBoolean(LEVELTHREE, false).equals(true)){
            acheiveString+= LEVELTHREE + " Completed!\n"
        }
        else{
            acheiveString+= LEVELTHREE + " Not Completed!\n"
            Btn9.setVisibility(View.GONE);
        }

        if(sharedPreferences.getBoolean(LEVELFOUR, false).equals(true)){
            acheiveString+= LEVELFOUR + " Completed!\n"
        }
        else{
            acheiveString+= LEVELFOUR + " Not Completed!\n"
        }
        var textViewAcheive = findViewById<TextView>(R.id.textView11)
        textViewAcheive.text = acheiveString
    }
    override fun onResume() {
        super.onResume()
        init()
    }
}
