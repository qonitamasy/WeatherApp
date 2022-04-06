package com.qonita.weatherapp

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object Constants {

    const val API_KEY: String = "2531ed6bf55d6050754754feded83ce5"
    const val METRIC_UNIT: String = "metric"

    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(context: Context): Boolean{
     //membuat object baru yang akan memberi kita layanan konektivitas
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as
                ConnectivityManager

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                val network = connectivityManager.activeNetwork ?: return false
                val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

                return when{
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else{
                val networkInfo = connectivityManager.activeNetworkInfo
                return  networkInfo != null && networkInfo.isConnectedOrConnecting
            }
    }
}