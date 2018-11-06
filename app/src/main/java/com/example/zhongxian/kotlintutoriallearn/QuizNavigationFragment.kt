package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QuizNavigationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QuizNavigationFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class QuizNavigationFragment : Fragment() {
    lateinit var sharedPreferences : SharedPreferences

    private var myPrefences = "myPrefs"
    private var LEVELONE = false
    private var LEVELTWO = false
    private var LEVELTHREE = false
    private var LEVELFOUR = false
    private var currentLevel = 1
    var acheiveString = ""
    lateinit var v : View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_quiz_navigation, container, false)
        sharedPreferences = activity!!.getSharedPreferences(myPrefences, Context.MODE_PRIVATE)
        init();

        var btnQuizLvl = v.findViewById<Button>(R.id.Btn6)
        btnQuizLvl.setOnClickListener{

            val ft = fragmentManager!!.beginTransaction()
            val quizLevel1Fragment = QuizLevel1Fragment()
            ft.replace(R.id.main, quizLevel1Fragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()
        }

        var btnQuizLv2 = v.findViewById<Button>(R.id.Btn7)
        btnQuizLv2.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizLevel2Fragment = QuizLevel2Fragment()
            ft.replace(R.id.main, quizLevel2Fragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()
        }
        var btnQuizLv3 = v.findViewById<Button>(R.id.Btn8)
        btnQuizLv3.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizLevel3Fragment = QuizLevel3Fragment()
            ft.replace(R.id.main, quizLevel3Fragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()
        }
        var btnQuizLv4 = v.findViewById<Button>(R.id.Btn9)
        btnQuizLv4.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizLevel4Fragment = QuizLevel4Fragment()
            ft.replace(R.id.main, quizLevel4Fragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()
        }
        return v
    }


    fun init(){
        acheiveString = ""
        var btn7 = v.findViewById<Button>(R.id.Btn7)
        btn7.visibility= View.VISIBLE;

        var btn8 = v.findViewById<Button>(R.id.Btn8)
        btn8.visibility= View.VISIBLE;

        var btn9 = v.findViewById<Button>(R.id.Btn9)
        btn9.visibility= View.VISIBLE;
        var userLevel = sharedPreferences.getInt("currentLevel",1)
//        Toast.makeText(getActivity(),"Current Level: " + userLevel,
//                Toast.LENGTH_SHORT).show()
        acheiveString += "User Level: " + userLevel + " \n"
        if(sharedPreferences.getBoolean("LEVELONE", false).equals(true)){
            acheiveString+= "Level One Completed!\n"
        }
        else{
            acheiveString+= "Level One Not Completed!\n"
            btn7.visibility= View.GONE;
        }

        if(sharedPreferences.getBoolean("LEVELTWO", false).equals(true)){
            acheiveString+= "Level Two Completed!\n"
        }
        else{
            acheiveString+= "Level Two Not Completed!\n"
            btn8.visibility= View.GONE;
        }

        if(sharedPreferences.getBoolean("LEVELTHREE", false).equals(true)){
            acheiveString+= "Level Three Completed!\n"
        }
        else{
            acheiveString+= "Level Three Not Completed!\n"
            btn9.visibility= View.GONE;
        }

        if(sharedPreferences.getBoolean("LEVELFOUR", false).equals(true)){
            acheiveString+= "Level Four Completed!\n"
        }
        else{
            acheiveString+= "Level Four Not Completed!\n"
        }
        var textViewAcheive = v.findViewById<TextView>(R.id.textView11)
        textViewAcheive.text = acheiveString
    }
    override fun onResume() {
        init()
        super.onResume()

    }
}
