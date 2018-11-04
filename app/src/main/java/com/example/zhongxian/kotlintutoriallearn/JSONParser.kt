package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject

class JSONParser(private var c: Context, private var jsonData: String, private var myImageView: ImageView) : AsyncTask<Void, Void, Boolean>() {

    private var listOfForecast = ArrayList<Forecast>()

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): Boolean {
        return parse()
    }

    override fun onPostExecute(isParsed: Boolean?) {
        super.onPostExecute(isParsed)

        if(isParsed!!) {
            if(listOfForecast[0].getIcon() == "partly-cloudy-night") {
                Toast.makeText(c, "Hey there it is getting late and the weather is great! Why not stay at home and learn some Kotlin!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.partlycloudy)
            } else if (listOfForecast[0].getIcon() == "clear-day") {
                Toast.makeText(c, "The sky is clear and the air is fresh, let's learn some kotlin today!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "clear-night") {
                Toast.makeText(c, "The sky is clear and the weather is cooling, why not learn some kotlin!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "rain") {
                Toast.makeText(c, "It is raining now...let's just stay at home and learn some kotlin!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "snow") {
                Toast.makeText(c, "Brrrrrr it's so cold! Let's just stay at home and learn kotlin!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "sleet") {
                Toast.makeText(c, "It is raining ice! I wouldn't go out if I were you..Let's just learn some kotlin!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "wind") {
                Toast.makeText(c, "The weather is cooling, why not study some kotlin before making plans!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "fog") {
                Toast.makeText(c, "It is foggy outside! Let's stay at home and study kotlin!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "cloudy") {
                Toast.makeText(c, "It is cloudy outside, why not stay at home and learn kotlin!", Toast.LENGTH_LONG).show()
            } else if (listOfForecast[0].getIcon() == "partly-cloudy-day") {
                Toast.makeText(c, "It is cloudy and it is still early, why not grab the chance and learn some kotlin now!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(c, "We are unsure what weather is this! Let us not risk it and stay at home and study!", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(c, "Unable to parse data", Toast.LENGTH_LONG).show()
            Toast.makeText(c, "This is the data we are trying to parse: " + jsonData, Toast.LENGTH_LONG).show()
        }
    }

    private fun parse():Boolean {
        try {
            listOfForecast.clear()
            val jo = JSONObject(jsonData)

            var forecast:Forecast
            var currently : JSONObject

            currently = jo.getJSONObject("currently")
            jsonData = currently.toString()

                if(currently != null) {
                    val icon = currently.getString("icon")
                    val weatherSummary = currently.getString("summary")
                    val cTemperature = currently.getDouble("temperature")

                    if(icon != null && weatherSummary != null && cTemperature != null) {
                        forecast = Forecast(icon, weatherSummary, cTemperature)
                        listOfForecast.add(forecast)
                    }
                }
            return true
        } catch(e:JSONException) {
            e.printStackTrace()
            return false
        }
    }

    class Forecast(private var icon : String, private var weatherSummary : String, private var cTemperature : Double) {
        fun getIcon(): String {
            return icon
        }

        fun getWeatherSummary() : String {
            return weatherSummary
        }

        fun getcTemperature() : Double {
            return cTemperature
        }
    }
}