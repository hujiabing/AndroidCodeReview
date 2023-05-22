package com.hjb.androidcodereview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hjb.androidcodereview.databinding.ActivityMainBinding
import com.hjb.androidcodereview.db.AppDataDB
import com.hjb.androidcodereview.delegate.Late
import com.hjb.baselib.util.DataStoreUtils
import com.hjb.baselib.utils.loge
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


@DelicateCoroutinesApi
class MainActivity : AppCompatActivity(), CoroutineScope by CoroutineScope(Dispatchers.Default) {
    companion object {
        const val OBJ1 = 0
        const val EXAMPLE_COUNTER = "EXAMPLE_COUNTER"
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

        contentView = DataBindingUtil.setContentView(this, R.layout.activity_main)
        demoData.name.set("3D")
        contentView.vClick = ViewClick(this)


    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }


    class ViewClick(var activity: MainActivity) {
        fun login() {
            val isLogin = DataStoreUtils.getDataSync(EXAMPLE_COUNTER, false)
            val i = MMKV.defaultMMKV().decodeInt(EXAMPLE_COUNTER, 0)
            loge("==isLogin==$isLogin==>$i")
            DataStoreUtils.putDataSync(EXAMPLE_COUNTER, true)
            MMKV.defaultMMKV().encode(EXAMPLE_COUNTER, 12)
//            val iLoginInterface = MyServiceLoader.load(ILoginInterface::class.java)
//            iLoginInterface?.startLoginActivity(activity)

        }

        fun toWeb() {

//            val iWebViewInterface = MyServiceLoader.load(IWebViewInterface::class.java)
//            iWebViewInterface?.startWebViewActivity(activity, "https://baidu.com", "百度")

            val isLogin = DataStoreUtils.getDataSync(EXAMPLE_COUNTER, false)
            val i = MMKV.defaultMMKV().decodeInt(EXAMPLE_COUNTER, 0)
            loge("==isLogin==$isLogin==>$i")
            DataStoreUtils.putDataSync(EXAMPLE_COUNTER, false)
            MMKV.defaultMMKV().encode(EXAMPLE_COUNTER, 19)
        }


    }


}


