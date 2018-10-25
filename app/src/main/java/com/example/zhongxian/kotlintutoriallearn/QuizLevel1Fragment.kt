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

                if(completedQuiz == false) {
                    userLevel = userLevel+1
                }
                //val navigationView = findViewById<NavigationView>(R.id.nav_view)
                val navigationView = getActivity()!!.nav_view
                val hView = navigationView.getHeaderView(0)
                val androidIcon = hView.findViewById<ImageView>(R.id.ivAndroidIcon)

//                var inflatedView = layoutInflater.inflate(R.layout.nav_header_main, null)
//                var imageView = hView.findViewById<ImageView>(R.id.iv1)
//                var textViewCurrentLevel = inflatedView.findViewById<TextView>(R.id.tvCurrentLevel)
//                var androidIcon = inflatedView.findViewById<ImageView>(R.id.ivAndroidIcon)
//                Toast.makeText(this,"AndroidIcon: " + androidIcon, Toast.LENGTH_LONG).show()
                if (userLevel == 2) {
                    Toast.makeText(getActivity(),"Attempting to change icon/image", Toast.LENGTH_LONG).show()
//                    Toast.makeText(getActivity(),"textView: " + R.id.tvCurrentLevel, Toast.LENGTH_LONG).show()
                    Toast.makeText(getActivity(),"ImageView: " + R.id.ivAndroidIcon, Toast.LENGTH_LONG).show()
                   Toast.makeText(getActivity(),"AndroidIcon: " + androidIcon, Toast.LENGTH_LONG).show()
                   Toast.makeText(getActivity(),"Drawable icon: " + R.drawable.level2icon, Toast.LENGTH_LONG).show()
          androidIcon.setImageResource(R.drawable.level2icon)
//                    androidIcon.setImageResource(R.drawable.level2icon)
//                    androidIcon.setImageDrawable(getResources().getDrawable(R.drawable.level2icon));
//                    textViewCurrentLevel.setText("Level 2")
                } else if (userLevel == 3) {
                    androidIcon.setImageDrawable(getResources().getDrawable(R.drawable.level3icon));
//                    imageView.setImageResource(R.drawable.level3icon)
//            textViewCurrentLevel.setText("Level 3")
                } else if (userLevel >= 4) {
                    androidIcon.setImageDrawable(getResources().getDrawable(R.drawable.level4icon));
//                    imageView.setImageResource(R.drawable.level4icon)
//            textViewCurrentLevel.setText("Level 4")
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


}
