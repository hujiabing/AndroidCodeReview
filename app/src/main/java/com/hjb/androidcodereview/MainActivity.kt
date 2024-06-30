package com.hjb.androidcodereview

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Debug
import android.os.IBinder
import android.os.Trace
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hjb.androidcodereview.databinding.ActivityMainBinding
import com.hjb.androidcodereview.db.AppDataDB
import com.hjb.androidcodereview.service.MyAidlService

import com.hjb.baselib.utils.loge
import kotlinx.coroutines.*
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.coroutines.CoroutineContext


@DelicateCoroutinesApi
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    companion object {
        const val OBJ1 = 0
        const val EXAMPLE_COUNTER = "EXAMPLE_COUNTER"
    }


    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    lateinit var contentView: ActivityMainBinding
    private val demoData by lazy {
        ViewModelProvider(this)[DemoData::class.java]
    }

    lateinit var db: AppDataDB
    private var num: Int = 0

    //    private val flutterEngine: FlutterEngine? = null
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView = DataBindingUtil.setContentView(this, R.layout.activity_main)
        demoData.name.set("3D")
        contentView.vClick = ViewClick(this)
//        demoData.setText(this, contentView.tvNumber)

//        hookAMS()

    }


    private fun hookAMS() {

    }


    fun getData() {


//        OkDemo.get(
//            "https://p-vp.autohome.com.cn/api/gpi?mid=6E3AB91C2FA0F9CE6F15C4841F4F2CE2&ft=mp4&strategy=1&mt=1",
//            null,
//            object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    loge(e.toString())
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    loge("=====>>>>"+Thread.currentThread().name)
//                }
//
//            })
    }


    override fun onDestroy() {
        super.onDestroy()

    }

    suspend fun test1() = coroutineScope {

    }

    class ViewClick(var activity: MainActivity) {

        fun containerClick() {
            loge("====containerClick=======")
        }

        fun login() {
//            val isLogin = DataStoreUtils.getDataSync(EXAMPLE_COUNTER, false)
//            val i = MMKV.defaultMMKV().decodeInt(EXAMPLE_COUNTER, 0)
//            loge("==isLogin==$isLogin==>$i")
//            DataStoreUtils.putDataSync(EXAMPLE_COUNTER, true)
//            MMKV.defaultMMKV().encode(EXAMPLE_COUNTER, 12)
//            val iLoginInterface = MyServiceLoader.load(ILoginInterface::class.java)
//            iLoginInterface?.startLoginActivity(activity)
//            val value = activity.demoData.num.value!! + 1
//            activity.demoData.num.value = value;
//            activity.getData()

            val intent = Intent()
            intent.action = "com.hjb.androidcodereview.IMyAidlInterface.aidl"
            intent.setPackage("com.hjb.androidcodereview")
//        val intent = Intent(this,MyAidlService::class.java)
//            activity.startService(intent)
            var b = activity.bindService(intent, object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    loge("===>>>onServiceConnected");
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    loge("===>>>onServiceDisconnected");
                }

            }, BIND_AUTO_CREATE)
            loge("====>>>>" + b)
        }


        fun toWeb() {


//            val isLogin = DataStoreUtils.getDataSync(EXAMPLE_COUNTER, false)
//            val i = MMKV.defaultMMKV().decodeInt(EXAMPLE_COUNTER, 0)
//            loge("==isLogin==$isLogin==>$i")
//            DataStoreUtils.putDataSync(EXAMPLE_COUNTER, false)
//            MMKV.defaultMMKV().encode(EXAMPLE_COUNTER, 19)
//            GlobalScope.launch {
//                launch {
//                    Log.e("============","sss")
//                    "asds".substring(10)
//                }
//
//            }

        }

    }


}




















