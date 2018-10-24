package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_quiz_level1.*

class QuizLevel1 : AppCompatActivity() {
    var correctIndexQ1 = ""
    var correctIndexQ2 = ""
    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELONE = false
    private var currentLevel = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_level1)
        correctIndexQ1 = getResources().getString(R.string.Question1Op1)
        correctIndexQ2 = getResources().getString(R.string.Question2Op3)
        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)

        val btnNext = findViewById<Button>(R.id.btn_nextLvl)
        if(!sharedPreferences.getBoolean("LEVELONE", false).equals(true)){
            btnNext.setVisibility(View.GONE);
        }

        val btnsubmit = findViewById<Button>(R.id.button2)
        btnsubmit.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs1 = findViewById<RadioGroup>(R.id.radio_groupQ1)
            var id: Int = qs1.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                if(correctIndexQ1.trim()== radio.text.trim()){
                    counterMarks++;
                    qs1.setBackgroundColor(0)
                }else{
                    qs1.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 1 is incorrect. \n"
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 1 is Not selected. \n"
                qs1.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            val qs2 = findViewById<RadioGroup>(R.id.radio_groupQ2)
             id = qs2.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio:RadioButton = findViewById(id)
                if(correctIndexQ2.trim()== radio.text.trim()){
                    counterMarks++;
                    qs2.setBackgroundColor(0)
                }else{
                    qs2.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 2 is incorrect. \n"
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 2 is not selected. \n"
                qs2.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            if(counterMarks>1){
                sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
                var userLevel = sharedPreferences.getInt("currentLevel",1)
                var quizCompletedBefore = sharedPreferences.getBoolean("LEVELONE", false)
                if (quizCompletedBefore != true) {
                    Toast.makeText(applicationContext,"Level completed before? " + quizCompletedBefore, Toast.LENGTH_SHORT).show()
                    userLevel = userLevel + 1
                }

                val editor = sharedPreferences.edit()
                editor.putBoolean("LEVELONE", true)
                editor.putInt("currentLevel", currentLevel)
                editor.apply()
                Toast.makeText(applicationContext,"All question correct \n  Level 1 Completed!\n You may move on to the next level",
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(applicationContext,toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }

        btnNext.setOnClickListener{
            Intent()
            val myIntent = Intent(this, QuizLevel2::class.java)
            startActivity(myIntent)
        }

    }
}
