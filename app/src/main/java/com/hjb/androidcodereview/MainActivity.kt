package com.hjb.androidcodereview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hjb.androidcodereview.databinding.ActivityMainBinding
import com.hjb.androidcodereview.db.AppDataDB
import com.hjb.androidcodereview.delegate.Late
import com.hjb.baselib.autoservice.ILoginInterface
import com.hjb.baselib.autoservice.IWebViewInterface
import com.hjb.baselib.autoservice.MyServiceLoader
import com.hjb.commonlib.utils.loge
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
        fun onDataQueryAll() {

//            val iWebViewInterface = MyServiceLoader.load(IWebViewInterface::class.java)
//            iWebViewInterface?.startWebViewActivity(activity, "https://baidu.com", "百度")

            val iLoginInterface = MyServiceLoader.load(ILoginInterface::class.java)
            iLoginInterface?.startLoginActivity(activity)
        }


    }


}


