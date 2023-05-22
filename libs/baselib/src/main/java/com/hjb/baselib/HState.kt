package com.hjb.baselib

import android.annotation.SuppressLint
import android.content.Context
import com.hjb.baselib.util.DataStoreUtils
import com.tencent.mmkv.MMKV


@SuppressLint("StaticFieldLeak")
object HState {
    private lateinit var mDataStore: DataStoreUtils

    var context: Context? = null
        private set

    fun initialize(c: Context?) {
        if (c == null) {
            return
        }
        context = c
        context?.apply {
            mDataStore = DataStoreUtils.init(this)
            MMKV.initialize(this)//初始化MMKV
        }
    }
}