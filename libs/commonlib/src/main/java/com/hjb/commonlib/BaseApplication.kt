package com.hjb.commonlib

import android.app.Application

/**
 *
 * @ClassName:      BaseApplication
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/21 17:03
 */
open class BaseApplication : Application() {
    companion object {
        lateinit var application: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

}