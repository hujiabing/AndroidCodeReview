package com.hjb.baselib

import android.app.Application
import com.hjb.baselib.util.DataStoreUtils
import com.tencent.mmkv.MMKV
import kotlin.properties.Delegates

//定义一些顶层函数
open class HBaseApplication : Application() {

    companion object {
        var bInstance: HBaseApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        bInstance = this
        init()
    }

    private fun init() {
        HState.initialize(this)
    }
}