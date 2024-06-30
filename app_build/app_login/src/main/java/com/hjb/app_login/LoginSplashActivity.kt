package com.hjb.app_login

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.provider.Settings.Global
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hjb.androidcodereview.IMyAidlInterface
import com.hjb.app_login.databinding.ActivityLoginSplashBinding
import com.hjb.baselib.utils.loge
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LoginSplashActivity : AppCompatActivity() {
    lateinit var mContentView: ActivityLoginSplashBinding
    var mAidlStub: IMyAidlInterface? = null
    var mIsConnecting = false
    private var mServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mAidlStub = IMyAidlInterface.Stub.asInterface(service)
            loge("已连接")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            loge("断开连接")
            Message.obtain()
        }

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContentView = DataBindingUtil.setContentView(this, R.layout.activity_login_splash)
        mContentView.vClick = ViewClick(this)

    }


    private fun startAIDLService() {
        mIsConnecting = true
        val intent = Intent()
        intent.action = "com.hjb.androidcodereview.IMyAidlInterface.aidl"
        intent.setClassName(
            "com.hjb.androidcodereview",
            "com.hjb.androidcodereview.service.MyAidlService"
        )
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE)
        mIsConnecting = false
    }

    class ViewClick(var activity: LoginSplashActivity) {
        fun startAIDLService() {
            takeIf {
                activity.mAidlStub == null && !activity.mIsConnecting
            }.let {
                activity.startAIDLService()
            }
        }

        fun add() {

            takeIf { activity.mIsConnecting }.let { activity.mAidlStub }?.let {
                GlobalScope.async {
                    for (i in 1..100) {
                        it.add(1)
                    }

                }
                GlobalScope.async {
                    for (i in 1..100) {
                        it.add(1)
                    }

                }

            }
        }

        fun getResult() {
            takeIf { activity.mIsConnecting }.let { activity.mAidlStub }?.let {
                loge("${it.result}")
                loge(Thread.currentThread().name)
            }
        }

        fun append() {
            takeIf { activity.mIsConnecting }.let { activity.mAidlStub }?.let {
                loge(it.append("您好", 3))
            }

        }
    }
}
