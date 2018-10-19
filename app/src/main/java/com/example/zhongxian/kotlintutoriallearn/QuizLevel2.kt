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
import kotlinx.android.synthetic.main.activity_quiz_level1.*

class QuizLevel2 : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELONE = "Level One"
    private var LEVELTWO = "Level Two"
    var correctIndexQ3 = ""
    var correctIndexQ4 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_level2)
        val btnNext = findViewById<Button>(R.id.btn_nextLvl)

        correctIndexQ3 = getResources().getString(R.string.Question3Op4)
        correctIndexQ4 = getResources().getString(R.string.Question4Op4)
        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
        if(!sharedPreferences.getBoolean(LEVELTWO, false).equals(true)){
            btnNext.setVisibility(View.GONE);
        }
        val submitBtn = findViewById<Button>(R.id.btnSubmit1)
        submitBtn.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs3 = findViewById<RadioGroup>(R.id.radio_groupQ3)
            var id: Int = qs3.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                if(correctIndexQ3.trim()== radio.text.trim()){
                    counterMarks++;
                    qs3.setBackgroundColor(0)
                }else{
                    qs3.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 3 is incorrect. \n"
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 3 is Not selected. \n"
                qs3.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            val qs4 = findViewById<RadioGroup>(R.id.radio_groupQ4)
            id = qs4.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = findViewById(id)
                if(correctIndexQ4.trim()== radio.text.trim().toString()){
                    counterMarks++;
                    qs4.setBackgroundColor(0)
                }else{
                    qs4.setBackgroundColor(getResources().getColor(R.color.colorPink))
                    toastMessage += "Question 4 is incorrect. \n"
                }

            }else{
                // If no radio button checked in this radio group
                toastMessage += "Question 4 is not selected. \n"
                qs4.setBackgroundColor(getResources().getColor(R.color.colorBlue))
            }

            if(counterMarks>1){
                val editor = sharedPreferences.edit()

                editor.putBoolean(LEVELTWO, true)
                editor.apply()
                Toast.makeText(applicationContext,"All question correct \n  Level 2 Completed!\n You may move on to the next level",
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(applicationContext,toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }
        btnNext.setOnClickListener{
            Intent()
            val myIntent = Intent(this, QuizLevel3::class.java)
            startActivity(myIntent)
        }

    }
}
