package com.example.zhongxian.kotlintutoriallearn


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class QuizLevel2Fragment : Fragment() {
    lateinit var v : View;

    var correctIndexQ3 = ""
    var correctIndexQ4 = ""
    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELTWO = "Level Two"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this
        v = inflater.inflate(R.layout.fragment_quiz_level2, container, false);

        correctIndexQ3 = getResources().getString(R.string.Question3Op4)
        correctIndexQ4 = getResources().getString(R.string.Question4Op4)
        val btnNext = v.findViewById<Button>(R.id.btn_nextLvl)
        sharedPreferences = activity!!.getSharedPreferences(myPrefences, Context.MODE_PRIVATE);
        if(!sharedPreferences.getBoolean(LEVELTWO, false).equals(true)){
            btnNext.setVisibility(View.GONE);
        }
        val submitBtn = v.findViewById<Button>(R.id.btnSubmit1)
        submitBtn.setOnClickListener{
            var toastMessage = "";
            var counterMarks =0;
            val qs3 = v.findViewById<RadioGroup>(R.id.radio_groupQ3)
            var id: Int = qs3.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = v.findViewById(id)
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

            val qs4 = v.findViewById<RadioGroup>(R.id.radio_groupQ4)
            id = qs4.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio: RadioButton = v.findViewById(id)
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
                Toast.makeText(getActivity(),"All question correct \n  Level 2 Completed!\n You may move on to the next level",
                        Toast.LENGTH_SHORT).show()
                btnNext.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(getActivity(),toastMessage,
                        Toast.LENGTH_SHORT).show()
            }
        }
        btnNext.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizLevel3Fragment = QuizLevel3Fragment()
            ft.replace(R.id.main, quizLevel3Fragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()
        }

        return v;
    }


}
