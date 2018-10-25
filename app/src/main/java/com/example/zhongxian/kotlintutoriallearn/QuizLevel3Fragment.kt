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
class QuizLevel3Fragment : Fragment() {
    lateinit var v : View;

    var correctIndexQ5 = ""
    var correctIndexQ6 = ""
    lateinit var sharedPreferences : SharedPreferences

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
        if(!sharedPreferences.getBoolean("LEVELTHREE", false).equals(true)){
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


}
