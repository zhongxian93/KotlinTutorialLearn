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
class QuizLevel3Fragment : Fragment() {
    lateinit var v : View;

    var correctIndexQ5 = ""
    var correctIndexQ6 = ""
    lateinit var sharedPreferences : SharedPreferences
    lateinit var qsAnsDBHelper: DBHelper
    private var myPrefences = "myPrefs"
    private var LEVELTHREE = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_quiz_level3, container, false);

        correctIndexQ5 = getResources().getString(R.string.Question5Op2)
        correctIndexQ6 = getResources().getString(R.string.Question6Op3)
        val btnNext = v.findViewById<Button>(R.id.btn_nextLvl)
        sharedPreferences = activity!!.getSharedPreferences(myPrefences, Context.MODE_PRIVATE);
        qsAnsDBHelper = DBHelper(v.context)
        setOption("5","6")//provide the question number and set up checked option
        var completedQuiz = sharedPreferences.getBoolean("LEVELTHREE",false)
        if(!completedQuiz.equals(true)){
            btnNext.setVisibility(View.GONE);
        }
        val submitBtn = v.findViewById<Button>(R.id.btnSubmit1)
        submitBtn.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs5 = v.findViewById<RadioGroup>(R.id.radio_groupQ5)

            var id: Int = qs5.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = v.findViewById(id)
                var qs1Data = qsAnsDBHelper.readQuestionAns("5")
                if(qs1Data.size >0){
                    updateQns("5", radio.text.toString());
                }else{
                    insertQns("5", radio.text.toString());
                }
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

            val qs6 = v.findViewById<RadioGroup>(R.id.radio_groupQ6)
            id = qs6.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = v.findViewById(id)
                var qs1Data = qsAnsDBHelper.readQuestionAns("6")
                if(qs1Data.size >0){
                    updateQns("6", radio.text.toString());
                }else{
                    insertQns("6", radio.text.toString());
                }
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
                var userLevel = sharedPreferences.getInt("currentLevel",1)
                completedQuiz = sharedPreferences.getBoolean("LEVELTHREE", false)
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
                editor.putBoolean("LEVELTHREE", true)
                editor.apply()
                Toast.makeText(getActivity(),"All question correct \n  Level 3 Completed!\n You may move on to the next level" ,
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(getActivity(),toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }

        btnNext.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizLevel4Fragment = QuizLevel4Fragment()
            ft.replace(R.id.main, quizLevel4Fragment, "NewFragmentTag")
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

            val radio: RadioButton = v.findViewById(R.id.q5Option1)
            if(radio.text.equals(qs1[0].answer)){
                radio.setChecked(true);
            }
            val radio2: RadioButton = v.findViewById(R.id.q5Optio2)
            if(radio2.text.equals(qs1[0].answer)){
                radio2.setChecked(true);
            }
            val radio3: RadioButton = v.findViewById(R.id.q5Option3)
            if(radio3.text.equals(qs1[0].answer)){
                radio3.setChecked(true);
            }
            val radio4: RadioButton = v.findViewById(R.id.q5Option4)
            if(radio4.text.equals(qs1[0].answer)){
                radio4.setChecked(true);
            }

        }
        var qs2 = qsAnsDBHelper.readQuestionAns(questionNum2)
        if(qs2.size >0){

            val radio: RadioButton = v.findViewById(R.id.q6Option1)
            if(radio.text.toString().equals(qs2[0].answer)){
                radio.setChecked(true);
            }
            val radio2: RadioButton = v.findViewById(R.id.q6Optio2)
            if(radio2.text.toString().equals(qs2[0].answer)){
                radio2.setChecked(true);
            }
            val radio3: RadioButton = v.findViewById(R.id.q6Option3)
            if(radio3.text.toString().equals(qs2[0].answer)){
                radio3.setChecked(true);
            }
            val radio4: RadioButton = v.findViewById(R.id.q6Option4)
            if(radio4.text.toString().equals(qs2[0].answer)){
                radio4.setChecked(true);
            }

        }
    }


}
