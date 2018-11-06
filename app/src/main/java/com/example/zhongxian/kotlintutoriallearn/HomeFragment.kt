package com.example.zhongxian.kotlintutoriallearn

import android.Manifest
import android.annotation.TargetApi
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
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
import android.location.LocationManager
import android.hardware.SensorManager
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.location.Location
import android.location.LocationListener
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale
import android.support.v4.content.PermissionChecker.checkSelfPermission
import android.support.v7.app.AlertDialog
import android.util.Log


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
class HomeFragment : Fragment() , LocationListener {
    private val permissionList =
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)


    private var jsonURL = "https://api.darksky.net/forecast/acd4aac73abe65a732116c69ca1c7614/"
    private var defaultLocation = "1.3521,103.8198"
    private var newLocation = "";
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        jsonURL = "https://api.darksky.net/forecast/acd4aac73abe65a732116c69ca1c7614/"
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)

        val locationManager = activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // seek permissions to do audio recording and to use camera
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (allPermissionsEnabled()) {
// permissions granted, no need to do anything
            } else {
                setupMultiplePermissions()
            }
        } else {
// it must be older than Marshmallow. As long as
// AndroidManifest.xml specifies the permissions,
// nothing else needed to be done.
        }



        val ivWeather = v.findViewById<ImageView>(R.id.iv_Weather)
        val tvWeather = v.findViewById<TextView>(R.id.tv_WeatherSummary)
        var btnGetWeather = v.findViewById<Button>(R.id.btn_getWeather)
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
            var location  = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this);
            if(location != null){
                newLocation= location.latitude.toString()+","+location.longitude

                //Toast.makeText(getActivity(),location.latitude.toString()+","+location.longitude ,Toast.LENGTH_LONG).show();
            }
        }
        if(newLocation != ""){
            InternetJSON(getActivity(), jsonURL+newLocation, ivWeather, tvWeather).execute()
        }else{
            InternetJSON(getActivity(), jsonURL+defaultLocation, ivWeather, tvWeather).execute()
        }



        btnGetWeather.setOnClickListener{
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {
                var location  = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location != null){
                    InternetJSON(getActivity(), jsonURL+location.latitude.toString()+","+location.longitude, ivWeather, tvWeather).execute()

                }else{
                    InternetJSON(getActivity(), jsonURL+defaultLocation, ivWeather, tvWeather).execute()
                }
            }else{
                InternetJSON(getActivity(), jsonURL+defaultLocation, ivWeather, tvWeather).execute()
            }
        }



        return v
    }


    override fun onLocationChanged(location: Location) {
        //update location
        newLocation= location.latitude.toString()+","+location.longitude
        //Toast.makeText(getActivity(),location.latitude.toString()+","+location.longitude ,Toast.LENGTH_LONG).show();

    }
    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }
    override fun onProviderDisabled(provider: String?) {

    }

    override fun onProviderEnabled(provider: String?) {

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun allPermissionsEnabled(): Boolean {
        return permissionList.none { checkSelfPermission(getActivity(),it) !=
                PackageManager.PERMISSION_GRANTED}
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun setupMultiplePermissions() {
        val remainingPermissions = permissionList.filter {
            checkSelfPermission(getActivity(),it) !=
                    PackageManager.PERMISSION_GRANTED }
        requestPermissions(remainingPermissions.toTypedArray(),
                101)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissionList:
    Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissionList, grantResults)
        if (requestCode == 101) {
            if(grantResults.any { it != PackageManager.PERMISSION_GRANTED }){
                @TargetApi(Build.VERSION_CODES.M)
                if(permissionList.any { shouldShowRequestPermissionRationale(it) }){
                    AlertDialog.Builder(getActivity())
                            .setMessage("Press Permissions to Decide Permission Again")
                            .setPositiveButton("Permissions") { dialog, which ->
                                setupMultiplePermissions() }
                            .setNegativeButton("Cancel") { dialog, which -> dialog.dismiss() }
                            .create()
                            .show()
                }
            }}
    }
}
