package id.rofyfirm.pokemonapps.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(val app: Application): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnectedToInternet()) throw IOException()
        return chain.proceed(chain.request())
    }

    @Suppress("DEPRECATION")
    private fun isConnectedToInternet(): Boolean {
        val connectivityManager =
            app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}