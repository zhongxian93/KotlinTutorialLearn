package com.example.zhongxian.kotlintutoriallearn


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class QuizLevel4Fragment : Fragment() {
    lateinit var v : View;

    private var myPrefences = "myPrefs"
    private var LEVELFOUR = false
    var correctIndexQ7 = ""
    var correctIndexQ8 = ""
    lateinit var sharedPreferences : SharedPreferences
    lateinit var qsAnsDBHelper: DBHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_quiz_level4, container, false);
        correctIndexQ7 = getResources().getString(R.string.Question7Op3)
        correctIndexQ8 = getResources().getString(R.string.Question8Op3)
        sharedPreferences = activity!!.getSharedPreferences(myPrefences, Context.MODE_PRIVATE);
        qsAnsDBHelper = DBHelper(v.context)
        setOption("7","8")//provide the question number and set up checked option
        var completedQuiz = sharedPreferences.getBoolean("LEVELFOUR", false)
        val btnNext = v.findViewById<Button>(R.id.btn_nextLvl)
        if(!completedQuiz.equals(true)){
            btnNext.setVisibility(View.GONE);
        }

        val submitBtn = v.findViewById<Button>(R.id.btnSubmit1)
        submitBtn.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs7 = v.findViewById<RadioGroup>(R.id.radio_groupQ7)
            var id: Int = qs7.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = v.findViewById(id)
                var qs1Data = qsAnsDBHelper.readQuestionAns("7")
                if(qs1Data.size >0){
                    updateQns("7", radio.text.toString());
                }else{
                    insertQns("7", radio.text.toString());
                }
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

            val qs8 = v.findViewById<RadioGroup>(R.id.radio_groupQ8)
            id = qs8.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = v.findViewById(id)
                var qs1Data = qsAnsDBHelper.readQuestionAns("8")
                if(qs1Data.size >0){
                    updateQns("8", radio.text.toString());
                }else{
                    insertQns("8", radio.text.toString());
                }
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
                var userLevel = sharedPreferences.getInt("currentLevel",1)
                completedQuiz = sharedPreferences.getBoolean("LEVELFOUR", false)
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
                editor.putBoolean("LEVELFOUR", true)
                editor.apply()
                Toast.makeText(getActivity(),"All question correct \n  Level 4 Completed!\n" +"You may return.",
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(getActivity(),toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }

        btnNext.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizNavigationFragment = QuizNavigationFragment()
            ft.replace(R.id.main, quizNavigationFragment, "NewFragmentTag")
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
            val radio: RadioButton = v.findViewById(R.id.q7Option1)
            if(radio.text.toString().equals(qs1[0].answer)){
                radio.setChecked(true);
            }
            val radio2: RadioButton = v.findViewById(R.id.q7Optio2)
            if(radio2.text.toString().equals(qs1[0].answer)){
                radio2.setChecked(true);
            }
            val radio3: RadioButton = v.findViewById(R.id.q7Option3)
            if(radio3.text.toString().equals(qs1[0].answer)){
                radio3.setChecked(true);
            }
            val radio4: RadioButton = v.findViewById(R.id.q7Option4)
            if(radio4.text.toString().equals(qs1[0].answer)){
                radio4.setChecked(true);
            }

        }
        var qs2 = qsAnsDBHelper.readQuestionAns(questionNum2)
        if(qs2.size >0){
            val radio: RadioButton = v.findViewById(R.id.q8Option1)
            if(radio.text.toString().equals(qs2[0].answer)){
                radio.setChecked(true);
            }
            val radio2: RadioButton = v.findViewById(R.id.q8Optio2)
            if(radio2.text.toString().equals(qs2[0].answer)){
                radio2.setChecked(true);
            }
            val radio3: RadioButton = v.findViewById(R.id.q8Option3)
            if(radio3.text.toString().equals(qs2[0].answer)){
                radio3.setChecked(true);
            }
            val radio4: RadioButton = v.findViewById(R.id.q8Option4)
            if(radio4.text.toString().equals(qs2[0].answer)){
                radio4.setChecked(true);
            }

        }
    }


}
