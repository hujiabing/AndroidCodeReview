package com.hjb.baselib.utils

import android.util.Log


/**
 *
 * @ClassName:      LogUtils
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/28 11:07
 */
private const val isLog: Boolean = true

private const val TAG: String = "======CUSTOM-LOG======>"

fun loge(srt: String) {
    if (isLog) {
        Log.e(TAG, srt)
    }
}