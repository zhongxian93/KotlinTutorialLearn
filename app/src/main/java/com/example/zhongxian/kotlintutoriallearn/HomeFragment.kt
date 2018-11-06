package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
    private var jsonURL = "https://api.darksky.net/forecast/acd4aac73abe65a732116c69ca1c7614/1.3521,103.8198"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)


        val ivWeather = v.findViewById<ImageView>(R.id.iv_Weather)
        val tvWeather = v.findViewById<TextView>(R.id.tv_WeatherSummary)
        var btnGetWeather = v.findViewById<Button>(R.id.btn_getWeather)
        InternetJSON(getActivity(), jsonURL, ivWeather, tvWeather).execute()
        btnGetWeather.setOnClickListener{
            InternetJSON(getActivity(), jsonURL, ivWeather, tvWeather).execute()
        }


        return v
    }
}
