package com.hjb.hwebview

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.hjb.baselib.autoservice.IWebViewInterface


import com.hjb.hwebview.utils.WebConstants

/**
 *
 * @ClassName:      WebViewServiceImpl
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/11/2 14:17
 */
@AutoService(IWebViewInterface::class)
class WebViewServiceImpl : IWebViewInterface {
    override fun startWebViewActivity(context: Context, url: String, title: String) {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra(WebConstants.TITLE, title)
            .putExtra(WebConstants.URL, url)
        context.startActivity(
            intent
        )
    }
}