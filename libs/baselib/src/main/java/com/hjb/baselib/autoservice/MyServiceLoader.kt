package com.hjb.baselib.autoservice

import java.util.*

/**
 *
 * @ClassName:      MyServiceLoader
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/11/2 16:10
 */
object MyServiceLoader {
    fun <T> load(service: Class<T>?): T? {
        return try {
            ServiceLoader.load(service).iterator().next()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}