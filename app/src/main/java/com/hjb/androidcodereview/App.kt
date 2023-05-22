package com.hjb.androidcodereview

import android.app.Application
import com.hjb.baselib.HBaseApplication

import kotlin.properties.Delegates

/**
 *
 * @ClassName:      App
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/14 5:52 PM
 */
class App : HBaseApplication() {
    companion object {
        var instance: App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}