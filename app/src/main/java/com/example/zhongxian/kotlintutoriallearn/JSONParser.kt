package com.example.zhongxian.kotlintutoriallearn

import android.content.Context
import android.graphics.Color
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject
import android.text.style.ForegroundColorSpan
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan


class JSONParser(private var c: Context, private var jsonData: String, private var myImageView: ImageView, private var myTextView : TextView) : AsyncTask<Void, Void, Boolean>() {

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
                myImageView.setImageResource(R.drawable.clearday)
            } else if (listOfForecast[0].getIcon() == "clear-night") {
                Toast.makeText(c, "The sky is clear and the weather is cooling, why not learn some kotlin!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.clearnight)
            } else if (listOfForecast[0].getIcon() == "rain") {
                Toast.makeText(c, "It is raining now...let's just stay at home and learn some kotlin!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.rain)
            } else if (listOfForecast[0].getIcon() == "snow") {
                Toast.makeText(c, "Brrrrrr it's so cold! Let's just stay at home and learn kotlin!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.snow)
            } else if (listOfForecast[0].getIcon() == "sleet") {
                Toast.makeText(c, "It is raining ice! I wouldn't go out if I were you..Let's just learn some kotlin!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.sleet)
            } else if (listOfForecast[0].getIcon() == "wind") {
                Toast.makeText(c, "The weather is cooling, why not study some kotlin before making plans!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.wind)
            } else if (listOfForecast[0].getIcon() == "fog") {
                Toast.makeText(c, "It is foggy outside! Let's stay at home and study kotlin!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.fog)
            } else if (listOfForecast[0].getIcon() == "cloudy") {
                Toast.makeText(c, "It is cloudy outside, why not stay at home and learn kotlin!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.cloudy)
            }
            else if (listOfForecast[0].getIcon() == "partly-cloudy-day") {
                Toast.makeText(c, "It is cloudy and it is still early, why not grab the chance and learn some kotlin now!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.cloudyday)
            }
                else {
                Toast.makeText(c, "We are unsure what weather is this! Let us not risk it and stay at home and study!", Toast.LENGTH_LONG).show()
                myImageView.setImageResource(R.drawable.unknown)
            }
            val builder = SpannableStringBuilder()

            var currentTemp = "%.1f".format(listOfForecast[0].getcTemperature()) + "\u00B0"
            val str1 = SpannableString(currentTemp)
            str1.setSpan(ForegroundColorSpan(Color.BLACK), 0, str1.length, 0)
            str1.setSpan(AbsoluteSizeSpan(120,true), 0, str1.length, 0)
            builder.append(str1)

            var feelslike = "\nFeels like: " + "%.1f".format(listOfForecast[0].getApparentTemperature()) + "\u00B0"
            val str2 = SpannableString(feelslike)
            str2.setSpan(AbsoluteSizeSpan(35, true), 0, str2.length, 0)
            builder.append(str2)

            var weatherSummary = "\n" + listOfForecast[0].getWeatherSummary()
            val str3 = SpannableString(weatherSummary)
            str3.setSpan(AbsoluteSizeSpan(40, true), 0, str3.length, 0)
            builder.append(str3)



            myTextView.setText(builder, TextView.BufferType.SPANNABLE)
//            myTextView.setText("Current weather summary: " + listOfForecast[0].getWeatherSummary() + "\n" + "Current temperature: " + "%.1f".format(listOfForecast[0].getcTemperature()) + "\nFeels like: " + "%.1f".format(listOfForecast[0].getApparentTemperature()) + "\nPrecipitation probability: " + "%.0f".format(listOfForecast[0].getPrecipProbability()) + "%")
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
                    var cTemperature = currently.getDouble("temperature")
                    var apparentTemperature = currently.getDouble("apparentTemperature")
                    var precipProbability = currently.getDouble("precipProbability")

                    if(icon != null && weatherSummary != null && cTemperature != null && apparentTemperature != null && precipProbability != null) {
                        cTemperature = (cTemperature-32)/1.8
                        apparentTemperature = (apparentTemperature-32)/1.8
                        precipProbability = precipProbability*100
                        forecast = Forecast(icon, weatherSummary, cTemperature, apparentTemperature, precipProbability)
                        listOfForecast.add(forecast)
                    }
                }
            return true
        } catch(e:JSONException) {
            e.printStackTrace()
            return false
        }
    }

    class Forecast(private var icon : String, private var weatherSummary : String, private var cTemperature : Double, private var apparentTemperature : Double, private var precipProbability : Double) {
        fun getIcon(): String {
            return icon
        }

        fun getWeatherSummary() : String {
            return weatherSummary
        }

        fun getcTemperature() : Double {
            return cTemperature
        }

        fun getApparentTemperature() : Double {
            return apparentTemperature
        }

        fun getPrecipProbability() : Double {
            return precipProbability
        }
    }
}