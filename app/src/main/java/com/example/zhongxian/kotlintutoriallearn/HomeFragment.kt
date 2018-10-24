package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        var btnHello = v.findViewById<Button>(R.id.Btn1)
        btnHello.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val helloWorldFragment = HelloWorldFragment()
            ft.replace(R.id.main, helloWorldFragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()

        }

        var btnVariable = v.findViewById<Button>(R.id.Btn2)
        btnVariable.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val variablesTypesFragment = VariablesTypesFragment()
            ft.replace(R.id.main, variablesTypesFragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()

        }

        var btnOperators = v.findViewById<Button>(R.id.Btn3)
        btnOperators.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val operatorsFragment = OperatorsFragment()
            ft.replace(R.id.main, operatorsFragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()

        }

        var btnConversion = v.findViewById<Button>(R.id.Btn4)
        btnConversion.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val conversionFragment = ConversionFragment()
            ft.replace(R.id.main, conversionFragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()

        }

        var btnQuiz = v.findViewById<Button>(R.id.Btn5)
        btnQuiz.setOnClickListener{
            val ft = fragmentManager!!.beginTransaction()
            val quizNavigationFragment = QuizNavigationFragment()
            ft.replace(R.id.main, quizNavigationFragment, "NewFragmentTag")
            ft.addToBackStack(null);
            ft.commit()
        }


        return v
    }
}
