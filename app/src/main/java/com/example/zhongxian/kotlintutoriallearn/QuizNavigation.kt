package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz_navigation.*

class QuizNavigation : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELONE = false
    private var LEVELTWO = false
    private var LEVELTHREE = false
    private var LEVELFOUR = false
    private var currentLevel = 1
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
        sharedPreferences = getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
        var currentLevel = sharedPreferences.getInt("currentLevel",1)
        acheiveString += "Current Level: " + currentLevel + " \n"

        if(sharedPreferences.getBoolean("LEVELONE" , false).equals(true)){
            acheiveString+= "Level One Completed!\n"
        }
        else{
            acheiveString+= "Level One Not Completed!\n"
            Btn7.setVisibility(View.GONE);
        }

        if(sharedPreferences.getBoolean("LEVELTWO", false).equals(true)){
            acheiveString+= "Level Two Completed!\n"
        }
        else{
            acheiveString+= "Level Two Not Completed!\n"
            Btn8.setVisibility(View.GONE);
        }

        if(sharedPreferences.getBoolean("LEVELTHREE", false).equals(true)){
            acheiveString+= "Level Three Completed!\n"
        }
        else{
            acheiveString+= "Level Three Not Completed!\n"
            Btn9.setVisibility(View.GONE);
        }

        if(sharedPreferences.getBoolean("LEVELFOUR", false).equals(true)){
            acheiveString+= "Level Four Completed!\n"
        }
        else{
            acheiveString+= "Level Four Not Completed!\n"
        }
        var textViewAcheive = findViewById<TextView>(R.id.textView11)
        textViewAcheive.text = acheiveString

        val textViewCurrentLevel = findViewById<TextView>(R.id.tvCurrentLevel)
        val androidIcon = findViewById<ImageView>(R.id.ivAndroidIcon)

        if (currentLevel == 2) {
            Toast.makeText(this,"Attempting to change icon/image", Toast.LENGTH_LONG).show()
            Toast.makeText(this,"textView: " + R.id.tvCurrentLevel, Toast.LENGTH_LONG).show()
            Toast.makeText(this,"ImageView: " + R.id.ivAndroidIcon, Toast.LENGTH_LONG).show()
//            androidIcon.setImageResource(R.drawable.level2icon)
//            textViewCurrentLevel.setText("Level 2")
        } else if (currentLevel == 3) {
//            androidIcon.setImageResource(R.drawable.level3icon)
//            textViewCurrentLevel.setText("Level 3")
        } else if (currentLevel >= 4) {
//            androidIcon.setImageResource(R.drawable.level4icon)
//            textViewCurrentLevel.setText("Level 4")
        }
    }
    override fun onResume() {
        super.onResume()
        init()
    }
}
