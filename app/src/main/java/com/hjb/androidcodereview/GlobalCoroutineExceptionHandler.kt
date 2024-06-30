package com.hjb.androidcodereview

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

class GlobalCoroutineExceptionHandler() : CoroutineExceptionHandler {
    override val key = CoroutineExceptionHandler
    override fun handleException(context: CoroutineContext, exception: Throwable) {
        println("============handleException>>>>>>>>${exception}")
        Log.e("====handleException>>", exception.message!!)

    }
}