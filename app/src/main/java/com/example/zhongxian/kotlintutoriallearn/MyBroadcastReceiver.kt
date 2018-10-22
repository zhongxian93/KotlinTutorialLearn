package com.example.zhongxian.kotlintutoriallearn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

//Extend from broadcastreceiver
class MyBroadcastReceiver : BroadcastReceiver(){

    companion object {
        lateinit var receiverListener: receiverListener
    }

    override fun onReceive(context: Context, intent: Intent) {
        receiverListener.onNetworkConnectionStatusChanged(connectionStatus(context))
    }
    private fun connectionStatus(context: Context) : Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }
    interface receiverListener {
        fun onNetworkConnectionStatusChanged(isConnected : Boolean)
    }
}