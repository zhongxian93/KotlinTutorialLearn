package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*
import java.sql.Types.TIMESTAMP

class QuizActivity : AppCompatActivity() {
    //store correct index for each Qs
    var correctIndexQ1 = ""
    var correctIndexQ2 = ""
    var correctIndexQ3 = ""
    var correctIndexQ4 = ""
    var correctIndexQ5 = ""
    var correctIndexQ6 = ""
    var correctIndexQ7 = ""
    var correctIndexQ8 = ""
    var correctIndexQ9 = 2
    var correctIndexQ10 = 2

    var counterMarks = 0;
    var counterQs = 0;

    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var SCORE = "score"
    private var numOfCorrect = -1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
        //sharedPreferences.edit().clear();
        if(!sharedPreferences.getString(SCORE, "na").equals("na")){

            textView9.setText("Previous score: " +  sharedPreferences.getString(SCORE, "na"))
        }
        correctIndexQ1 = getResources().getString(R.string.Question1Op1)
        correctIndexQ2 = getResources().getString(R.string.Question2Op3)
        correctIndexQ3 = getResources().getString(R.string.Question3Op4)
        correctIndexQ4 = getResources().getString(R.string.Question4Op4)
        correctIndexQ5 = getResources().getString(R.string.Question5Op2)
        correctIndexQ6 = getResources().getString(R.string.Question6Op3)
        correctIndexQ7 = getResources().getString(R.string.Question7Op3)
        correctIndexQ8 = getResources().getString(R.string.Question8Op3)
        radio_groupQ1.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener { group, checkedId ->
                    val radio: RadioButton = findViewById(checkedId)
                    //Toast.makeText(applicationContext," On checked change : ${radio.text}",  Toast.LENGTH_SHORT).show()
                })


        // Get radio group selected status and text using button click event
        button.setOnClickListener{


            counterMarks = 0;
            counterQs = 0;
            // Get the checked radio button id from radio group
            this.check_radio_groupQ1()
            this.check_radio_groupQ2()
            this.check_radio_groupQ3()
            this.check_radio_groupQ4()
            this.check_radio_groupQ5()
            this.check_radio_groupQ6()
            this.check_radio_groupQ7()
            this.check_radio_groupQ8()
            Toast.makeText(applicationContext,"${counterMarks} correct our of ${counterQs}",  Toast.LENGTH_SHORT).show()
            val editor = sharedPreferences.edit()

            editor.putString(SCORE, counterMarks.toString()+"/" +counterQs)
            editor.apply()
            textView9.setText("Prevvous score: " + counterMarks.toString()+"/" +counterQs)
        }
    }

    fun check_radio_groupQ1(){
        counterQs++;
        var id: Int = radio_groupQ1.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ1.trim()== radio.text.trim()){
                counterMarks++;
                radio_groupQ1.setBackgroundColor(0)
            }else{
                radio_groupQ1.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

        }else{
            // If no radio button checked in this radio group
            radio_groupQ1.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }

    fun check_radio_groupQ2(){
        counterQs++;
        var id: Int = radio_groupQ2.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ2.trim()== radio.text.trim()){
                counterMarks++;
            }else{
                radio_groupQ2.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

            /*
            val radio:RadioButton = findViewById(id)
            Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()
                    */
        }else{
            // If no radio button checked in this radio group
            radio_groupQ2.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }

    fun check_radio_groupQ3(){
        counterQs++;
        var id: Int = radio_groupQ3.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ3.trim()== radio.text.trim()){
                counterMarks++;
            }else{
                radio_groupQ3.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

            /*
            val radio:RadioButton = findViewById(id)
            Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()
                    */
        }else{
            // If no radio button checked in this radio group
            radio_groupQ3.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }
    fun check_radio_groupQ4(){
        counterQs++;
        var id: Int = radio_groupQ4.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ4.trim()== radio.text.trim().toString()){
                counterMarks++;
            }else{
                radio_groupQ4.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

            /*
            val radio:RadioButton = findViewById(id)
            Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()
                    */
        }else{
            // If no radio button checked in this radio group
            radio_groupQ4.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }
    fun check_radio_groupQ5(){
        counterQs++;
        var id: Int = radio_groupQ5.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ5.trim()== radio.text.trim()){
                counterMarks++;
            }else{
                radio_groupQ5.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

            /*
            val radio:RadioButton = findViewById(id)
            Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()
                    */
        }else{
            // If no radio button checked in this radio group
            radio_groupQ5.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }
    fun check_radio_groupQ6(){
        counterQs++;
        var id: Int = radio_groupQ6.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ6.trim()== radio.text.trim()){
                counterMarks++;
            }else{
                radio_groupQ6.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

            /*
            val radio:RadioButton = findViewById(id)
            Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()
                    */
        }else{
            // If no radio button checked in this radio group
            radio_groupQ6.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }
    fun check_radio_groupQ7(){
        counterQs++;
        var id: Int = radio_groupQ7.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ7.trim()== radio.text.trim().toString()){
                counterMarks++;
            }else{
                Toast.makeText(applicationContext,"Selected : ${radio.text}",
                        Toast.LENGTH_SHORT).show()

                Toast.makeText(applicationContext,"From Text : ${correctIndexQ7}",
                        Toast.LENGTH_SHORT).show()
                radio_groupQ7.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

            /*
            val radio:RadioButton = findViewById(id)
            Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()
                    */
        }else{
            // If no radio button checked in this radio group
            radio_groupQ7.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }
    fun check_radio_groupQ8(){
        counterQs++;
        var id: Int = radio_groupQ8.checkedRadioButtonId
        if (id!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio:RadioButton = findViewById(id)
            if(correctIndexQ8.trim()== radio.text.trim().toString()){
                counterMarks++;
            }else{
                radio_groupQ8.setBackgroundColor(getResources().getColor(R.color.colorPink))
            }

            /*
            val radio:RadioButton = findViewById(id)
            Toast.makeText(applicationContext,"On button click : ${radio.text}",
                    Toast.LENGTH_SHORT).show()
                    */
        }else{
            // If no radio button checked in this radio group
            radio_groupQ8.setBackgroundColor(getResources().getColor(R.color.colorBlue))
        }
    }
    // Get the selected radio button text using radio button on click listener
    /*
    fun radio_button_click(view: View){
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(radio_groupQ1.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Selected : ${radio.text}",
                Toast.LENGTH_SHORT).show()
    }
    */

}
