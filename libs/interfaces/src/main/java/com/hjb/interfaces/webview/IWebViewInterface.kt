package com.hjb.interfaces.webview

import android.content.Context

/**
 *
 * @ClassName:      IWebviewInterface
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/11/2 14:10
 */
interface IWebViewInterface {
    fun startWebViewActivity(context: Context, url: String, title: String)
}