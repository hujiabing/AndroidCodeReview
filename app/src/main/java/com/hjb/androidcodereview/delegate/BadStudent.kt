package com.hjb.androidcodereview.delegate

import android.util.Log

/**
 *
 * @ClassName:      BadStudent
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/21 10:34
 */
class BadStudent(val homeWork: HomeWork) : HomeWork by homeWork {
    fun playGame() {
        Log.e("===>>>", "打游戏")
    }
}