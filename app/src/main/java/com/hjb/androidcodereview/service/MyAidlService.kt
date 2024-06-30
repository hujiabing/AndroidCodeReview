package com.hjb.androidcodereview.service

import android.app.Service
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import com.hjb.androidcodereview.IMyAidlInterface
import com.hjb.androidcodereview.SplashActivity
import com.hjb.baselib.utils.loge

class MyAidlService : Service() {

    var mHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun dispatchMessage(msg: Message) {
            super.dispatchMessage(msg)
            if (msg.what == 2) {
                val intent = Intent(applicationContext,SplashActivity::class.java)
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK)

                startActivity(intent)
            }
        }
    }

    @Volatile
    var mResult = 20
    var stub: IMyAidlInterface.Stub = object : IMyAidlInterface.Stub() {
        override fun add(num: Int) {

            mResult += num
            loge("${Thread.currentThread().name}=====服务端结果:$mResult")

            mHandler.sendEmptyMessage(2)
        }

        override fun getResult(): Int {
            return mResult
        }

        override fun append(str: String?, num: Int): String {
            loge("${Thread.currentThread().name}=====服务端收到:$str,$num")
            mResult += num
            return "$str,追加$num,结果是:${mResult}"
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        loge("${Thread.currentThread().name}=======>>>MyAidlService onBind")
        return stub
    }

    override fun onCreate() {
        super.onCreate()
        loge("${Thread.currentThread().name}=======>>>MyAidlService onCreate")
    }
}