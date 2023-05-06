package com.hjb.androidcodereview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hjb.androidcodereview.databinding.ActivityMainBinding
import com.hjb.androidcodereview.db.AppDataDB
import com.hjb.androidcodereview.delegate.Late
import com.hjb.interfaces.MyServiceLoader
import com.hjb.interfaces.login.ILoginInterface
import com.hjb.interfaces.webview.IWebViewInterface
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext


@DelicateCoroutinesApi
class MainActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.Default) {
    companion object {
        const val OBJ1 = 0
    }

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    lateinit var contentView: ActivityMainBinding
    private val demoData by lazy {
        ViewModelProvider(this)[DemoData::class.java]
    }
    val demo by Late {
        ViewModelProvider(this)[DemoData::class.java]
    }
    lateinit var db: AppDataDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contentView =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        demoData.name.set("3D")
        contentView.vClick = ViewClick(this)


    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }


    class ViewClick(var activity: MainActivity) {
        fun login() {


            val iLoginInterface = MyServiceLoader.load(ILoginInterface::class.java)
            iLoginInterface?.startLoginActivity(activity)
        }

        fun toWeb() {

            val iWebViewInterface = MyServiceLoader.load(IWebViewInterface::class.java)
            iWebViewInterface?.startWebViewActivity(activity, "https://baidu.com", "百度")

        }


    }


}


