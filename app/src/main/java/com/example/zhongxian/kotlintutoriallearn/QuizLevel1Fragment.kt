package com.example.zhongxian.kotlintutoriallearn


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatImageView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_hello_world.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class QuizLevel1Fragment : Fragment() {
    lateinit var v : View;

    var correctIndexQ1 = ""
    var correctIndexQ2 = ""
    lateinit var sharedPreferences : SharedPreferences
    lateinit var qsAnsDBHelper: DBHelper

    private var myPrefences = "myPrefs"
    private var LEVELONE = false
    private var currentLevel = 1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_quiz_level1, container, false);

        correctIndexQ1 = getResources().getString(R.string.Question1Op1)
        correctIndexQ2 = getResources().getString(R.string.Question2Op3)
        sharedPreferences = activity!!.getSharedPreferences(myPrefences, Context.MODE_PRIVATE);
        qsAnsDBHelper = DBHelper(v.context)
        setOption("1","2")//provide the question number and set up checked option
        var completedQuiz = sharedPreferences.getBoolean("LEVELONE",false)
        val btnNext = v.findViewById<Button>(R.id.btn_nextLvl)
        if(!completedQuiz.equals(true)){
            btnNext.setVisibility(View.GONE);
        }

        val btnsubmit = v.findViewById<Button>(R.id.button2)
        btnsubmit.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs1 = v.findViewById<RadioGroup>(R.id.radio_groupQ1)
            var id: Int = qs1.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id

                val radio: RadioButton = v.findViewById(id)
                var qs1Data = qsAnsDBHelper.readQuestionAns("1")
                if(qs1Data.size >0){
                    updateQns("1", radio.text.toString());
                }else{
                    insertQns("1", radio.text.toString());
                }
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

            val qs2 = v.findViewById<RadioGroup>(R.id.radio_groupQ2)
            id = qs2.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = v.findViewById(id)
                var qs1Data = qsAnsDBHelper.readQuestionAns("2")
                if(qs1Data.size >0){
                    updateQns("2", radio.text.toString());
                }else{
                    insertQns("2", radio.text.toString());
                }
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
                val editor = sharedPreferences.edit()
                var userLevel = sharedPreferences.getInt("currentLevel",1)
                completedQuiz = sharedPreferences.getBoolean("LEVELONE", false)
                if(completedQuiz == false) {
                    userLevel = userLevel+1
                }
                //val navigationView = findViewById<NavigationView>(R.id.nav_view)
                val navigationView = getActivity()!!.nav_view
                val hView = navigationView.getHeaderView(0)
                val androidIcon = hView.findViewById<ImageView>(R.id.ivAndroidIcon)
                val textViewCurrentLevel = hView.findViewById<TextView>(R.id.tvCurrentLevel)
                if (userLevel == 2) {
                    androidIcon.setImageResource(R.drawable.level2icon)
                    textViewCurrentLevel.setText("Level 2")
                } else if (userLevel == 3) {
                    androidIcon.setImageResource(R.drawable.level3icon)
//                    imageView.setImageResource(R.drawable.level3icon)
                    textViewCurrentLevel.setText("Level 3")
                } else if (userLevel == 4) {
                    androidIcon.setImageResource(R.drawable.level4icon)
                    textViewCurrentLevel.setText("Level 4")
                } else if (userLevel == 5) {
                    androidIcon.setImageResource(R.drawable.level5icon)
                    textViewCurrentLevel.setText("Level 5")
                }
                Toast.makeText(getActivity(),"Current Level: " + userLevel,
                        Toast.LENGTH_SHORT).show()
                editor.putInt("currentLevel", userLevel)
                editor.putBoolean("LEVELONE", true)
                editor.apply()
                Toast.makeText(getActivity(),"All question correct \n  Level 1 Completed!\n You may move on to the next level",
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(getActivity(),toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }

        btnNext.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizLevel2Fragment = QuizLevel2Fragment()
            ft.replace(R.id.main, quizLevel2Fragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()
        }
        return v;
    }

    fun updateQns(qsNum:String, qsAns:String){
        var result = qsAnsDBHelper.updateQuestionAns(qsNum,qsAns);

    }

    fun insertQns(qsNum:String, qsAns:String){
        var result = qsAnsDBHelper.insertQuestionAns(DataRecord(qsNum, qsAns))

    }
    fun setOption(questionNum1:String, questionNum2:String) {
        var qs1 = qsAnsDBHelper.readQuestionAns(questionNum1)
        if(qs1.size >0){

            val radio: RadioButton = v.findViewById(R.id.q1Option1)
            if(radio.text.equals(qs1[0].answer)){
                radio.setChecked(true);
            }
            val radio2: RadioButton = v.findViewById(R.id.q1Option2)
            if(radio2.text.equals(qs1[0].answer)){
                radio2.setChecked(true);
            }
            val radio3: RadioButton = v.findViewById(R.id.q1Option3)
            if(radio3.text.equals(qs1[0].answer)){
                radio3.setChecked(true);
            }
            val radio4: RadioButton = v.findViewById(R.id.q1Option4)
            if(radio4.text.equals(qs1[0].answer)){
                radio4.setChecked(true);
            }

        }
        var qs2 = qsAnsDBHelper.readQuestionAns(questionNum2)
        if(qs2.size >0){

            val radio: RadioButton = v.findViewById(R.id.q2Option1)
            if(radio.text.toString().equals(qs2[0].answer)){
                radio.setChecked(true);
            }
            val radio2: RadioButton = v.findViewById(R.id.q2Optio2)
            if(radio2.text.toString().equals(qs2[0].answer)){
                radio2.setChecked(true);
            }
            val radio3: RadioButton = v.findViewById(R.id.q2Option3)
            if(radio3.text.toString().equals(qs2[0].answer)){
                radio3.setChecked(true);
            }
            val radio4: RadioButton = v.findViewById(R.id.q2Option4)
            if(radio4.text.toString().equals(qs2[0].answer)){
                radio4.setChecked(true);
            }

        }
    }


}
