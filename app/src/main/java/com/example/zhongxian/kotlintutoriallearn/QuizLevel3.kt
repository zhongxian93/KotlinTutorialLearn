package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz_level3.*

class QuizLevel3 : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELTHREE = false
    var correctIndexQ5 = ""
    var correctIndexQ6 = ""
    private var currentLevel = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_level3)
        correctIndexQ5 = getResources().getString(R.string.Question5Op2)
        correctIndexQ6 = getResources().getString(R.string.Question6Op3)
        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
        val btnNext = findViewById<Button>(R.id.btn_nextLvl)
        if(!sharedPreferences.getBoolean("LEVELTHREE", false).equals(true)){
            btnNext.setVisibility(View.GONE);
        }

        val submitBtn = findViewById<Button>(R.id.btnSubmit1)
        submitBtn.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs5 = findViewById<RadioGroup>(R.id.radio_groupQ5)
            var id: Int = qs5.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                if(correctIndexQ5.trim()== radio.text.trim()){
                    counterMarks++;
                    qs5.setBackgroundColor(0)
                }else{
                    qs5.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 5 is incorrect. \n"
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 5 is Not selected. \n"
                qs5.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            val qs6 = findViewById<RadioGroup>(R.id.radio_groupQ6)
            id = qs6.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                if(correctIndexQ6.trim()== radio.text.trim().toString()){
                    counterMarks++;
                    qs6.setBackgroundColor(0)
                }else{
                    qs6.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 6 is incorrect. \n"
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 6 is not selected. \n"
                qs6.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            if(counterMarks>1){
                val editor = sharedPreferences.edit()
                sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
                var currentLevel = sharedPreferences.getInt("currentLevel",1)
                var quizCompletedBefore = sharedPreferences.getBoolean("LEVELTHREE", false)
                if (quizCompletedBefore != true) {
                    Toast.makeText(applicationContext,"Level completed before? " + quizCompletedBefore, Toast.LENGTH_SHORT).show()
                    currentLevel = currentLevel + 1
                }



                editor.putInt("currentLevel", currentLevel)
                editor.putBoolean("LEVELTHREE", true)
                editor.apply()
                Toast.makeText(applicationContext,"All question correct \n  Level 3 Completed!\n You may move on to the next level" ,
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(applicationContext,toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }

        btnNext.setOnClickListener{
            Intent()
            val myIntent = Intent(this, QuizLevel4::class.java)
            startActivity(myIntent)
        }

    }
}
