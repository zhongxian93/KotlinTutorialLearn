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

class QuizLevel4 : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELFOUR = false
    private var currentLevel = 1
    var correctIndexQ7 = ""
    var correctIndexQ8 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_level4)

        correctIndexQ7 = getResources().getString(R.string.Question7Op3)
        correctIndexQ8 = getResources().getString(R.string.Question8Op3)
        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)

        val btnNext = findViewById<Button>(R.id.btn_nextLvl)
        if(!sharedPreferences.getBoolean("LEVELFOUR", false).equals(true)){
            btnNext.setVisibility(View.GONE);
        }

        val submitBtn = findViewById<Button>(R.id.btnSubmit1)
        submitBtn.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs7 = findViewById<RadioGroup>(R.id.radio_groupQ7)
            var id: Int = qs7.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                if(correctIndexQ7.trim()== radio.text.trim().toString()){
                    counterMarks++;
                    qs7.setBackgroundColor(0)
                }else{
                    qs7.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 7 is incorrect. \n"
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 7 is Not selected. \n"
                qs7.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            val qs8 = findViewById<RadioGroup>(R.id.radio_groupQ8)
            id = qs8.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                if(correctIndexQ8.trim()== radio.text.trim().toString()){
                    counterMarks++;
                    qs8.setBackgroundColor(0)
                }else{
                    qs8.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 8 is incorrect."
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 8 is not selected."
                qs8.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            if(counterMarks>1){
                val editor = sharedPreferences.edit()
                sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
                var currentLevel = sharedPreferences.getInt("currentLevel",1)
                var quizCompletedBefore = sharedPreferences.getBoolean("LEVELFOUR", false)
                if (quizCompletedBefore != true) {
                    Toast.makeText(applicationContext,"Level completed before? " + quizCompletedBefore, Toast.LENGTH_SHORT).show()
                    currentLevel = currentLevel + 1
                }



                editor.putInt("currentLevel", currentLevel)
                editor.putBoolean("LEVELFOUR", true)
                editor.apply()
                Toast.makeText(applicationContext,"All question correct \n  Level 4 Completed!\n" +"You may return.",
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(applicationContext,toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }

        btnNext.setOnClickListener{
            Intent()
            val myIntent = Intent(this, QuizNavigation::class.java)
            startActivity(myIntent)
        }
    }
}
