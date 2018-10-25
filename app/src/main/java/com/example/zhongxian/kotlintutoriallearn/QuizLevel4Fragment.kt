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
class QuizLevel4Fragment : Fragment() {
    lateinit var v : View;

    private var myPrefences = "myPrefs"
    private var LEVELFOUR = false
    var correctIndexQ7 = ""
    var correctIndexQ8 = ""
    lateinit var sharedPreferences : SharedPreferences


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_quiz_level4, container, false);
        correctIndexQ7 = getResources().getString(R.string.Question7Op3)
        correctIndexQ8 = getResources().getString(R.string.Question8Op3)
        sharedPreferences = activity!!.getSharedPreferences(myPrefences, Context.MODE_PRIVATE);

        val btnNext = v.findViewById<Button>(R.id.btn_nextLvl)
        if(!sharedPreferences.getBoolean("LEVELFOUR", false).equals(true)){
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


}
