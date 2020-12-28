package com.cyb.musicplayer.util

import android.os.Handler
import android.os.Looper
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Paradoox on 2020/12/23.
 */

private const val BASE_URL = "http://123.57.173.58:3000"
private const val TAG = "Network"

object BaseNetwork {
    class LogInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            Log.d(TAG, "send request to: $request")
            val time = System.nanoTime()
            val response = chain.proceed(request)
            if (response.isSuccessful) {
                Log.d(
                    TAG,
                    // invoke response.body() will close the connection,
                    // so can't do that in the interceptor
                    "get response: ${response.peekBody(4096)} successfully in ${(System.nanoTime() - time).toDouble() / 1e6}ms)"
                )
            } else {
                Log.e(
                    TAG,
                    "get response failed in ${(System.nanoTime() - time).toDouble() / 1e6}ms)"
                )
            }
            return response
        }
    }

    class FailureInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val response = chain.proceed(chain.request())
            if (!response.isSuccessful) {
                Handler(Looper.getMainLooper()).post {
                    MyApplication.globalContext.showMsg("Network error")
                }
            }
            return response
        }
    }

    private val okhttp by lazy {
        OkHttpClient.Builder()
            // the ::intercept method is invoked in adding order when send request and
            // in reversed order when received response
            .addInterceptor(LogInterceptor())
            .addNetworkInterceptor(FailureInterceptor())
            .build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttp)
            .build()
    }

    inline operator fun <reified T> invoke(): T = retrofit.create(T::class.java)
}