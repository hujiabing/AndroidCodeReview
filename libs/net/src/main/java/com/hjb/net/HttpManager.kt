package com.hjb.net

import android.util.Log
import com.hjb.net.converter.FastJsonConverterFactory
import com.hjb.net.interceptor.CommonHeaderInterceptor
import com.hjb.net.interceptor.CommonParamInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

/**
 *
 * @ClassName:      HttpManager
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/21 15:38
 */
object HttpManager {
    private var baseUrl = BASE_URL
    private val isDebug = IS_DEBUG

    //获取okHttp对象
    private val okHttpClient: OkHttpClient
    private val mRetrofit: Retrofit

    init {
        this.okHttpClient = createOkHttpClient()
        this.mRetrofit = createRetrofit()
    }

    //创建Retrofit
    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(FastJsonConverterFactory.create())
            .build()
    }

    //创建OkHttpClient
    private fun createOkHttpClient(): OkHttpClient {

        val srcBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptors(getInterceptors())
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
        //处理https
        httpSSl(srcBuilder)
        return srcBuilder.build()
    }

    //处理https
    private fun httpSSl(srcBuilder: OkHttpClient.Builder) {
        if (baseUrl.startsWith("https:")) {
            try {
                val sslParams = SSLUtil.getSslSocketFactory(null, null, null)
                srcBuilder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                srcBuilder.hostnameVerifier { _, _ -> true }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * 添加通用请求头和参数拦截器
     */
    private fun OkHttpClient.Builder.addInterceptors(list: List<Interceptor>): OkHttpClient.Builder {
        for (interceptor in list) {
            this.addInterceptor(interceptor)
        }
        return this
    }

    /**
     * 获取需要添加的拦截器链
     */
    private fun getInterceptors(): List<Interceptor> {
        val list = ArrayList<Interceptor>()
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
        if (isDebug) {
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

    /**
     * 生成api对象
     */
    fun <T> createApi(clazz: Class<T>): T {
        return mRetrofit.create(clazz)
    }
}