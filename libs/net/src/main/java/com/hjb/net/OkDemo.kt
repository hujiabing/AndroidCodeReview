package com.hjb.net


import android.util.Log
import com.alibaba.fastjson.JSON
import com.hjb.net.interceptor.CommonHeaderInterceptor
import com.hjb.net.interceptor.CommonParamInterceptor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Callback
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkDemo {
    private const val BASE_URL = "https://www.wanandroid.com"
    private val okHttpClient: OkHttpClient

    init {
        okHttpClient = createOkhttpClient()
    }

    fun getInstance(): OkHttpClient {
        return okHttpClient
    }

    private fun createOkhttpClient(): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
            .addInterceptors(getInterceptors())
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        dealSSl(okBuilder)
        return okBuilder
            .build()
    }

    private fun dealSSl(okBuilder: OkHttpClient.Builder) {
        if (BASE_URL.startsWith("https")) {
            try {
                val sslParams = SSLUtil.getSslSocketFactory(null, null, null)
                okBuilder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                okBuilder.hostnameVerifier { _, _ -> true }
            } catch (e: Exception) {
            }
        }

    }

    private fun getInterceptors(): MutableList<Interceptor> {
        val list = mutableListOf<Interceptor>()
        list.add(CommonHeaderInterceptor())
        list.add(CommonParamInterceptor())
        val logInterceptor = getLogInterceptor()
        logInterceptor?.let {
            list.add(it)
        }
        return list
    }

    /**
     *  获取日志拦截器
     */
    private fun getLogInterceptor(): Interceptor? {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor { message ->
                try {
                    Log.e("HTTP", message)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            return loggingInterceptor
        }
        return null
    }


    fun OkHttpClient.Builder.addInterceptors(list: MutableList<Interceptor>): OkHttpClient.Builder {
        if (list.isNotEmpty()) {
            for (interceptor in list) {
                this.addInterceptor(interceptor)
            }
        }
        return this
    }

    suspend fun get(url: String, params: MutableMap<String, Any>?) = coroutineScope {
        val requestUrl = dealUrl(url, params)
        val request: Request = Request.Builder()
            .url(requestUrl)
            .get()
            .build()
        getInstance().newCall(request).execute()

    }


    fun post(url: String, params: MutableMap<String, Any>, callback: Callback) {
        val requestData = JSON.toJSONString(params)
        val requestUrl = dealUrl(url, params)
        val request: Request = Request.Builder()
            .url(requestUrl)
            .post(requestData.toRequestBody("application/json".toMediaType()))
            .build()
        getInstance().newCall(request).enqueue(callback)
    }

    private fun dealUrl(url: String, params: MutableMap<String, Any>?): String {
        val sb: StringBuilder = StringBuilder(url)
        params?.run {
            forEach {
                if (sb.contains("?")) {
                    sb.append("&")
                    sb.append(it.key)
                    sb.append("=")
                    sb.append(it.value)
                } else {
                    sb.append("?")
                    sb.append(it.key)
                    sb.append("=")
                    sb.append(it.value)
                }
            }
        }
        return sb.toString()
    }

    fun delData() {}
}