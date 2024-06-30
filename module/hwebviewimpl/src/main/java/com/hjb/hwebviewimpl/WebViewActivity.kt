package com.hjb.hwebviewimpl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil

import com.hjb.hwebview.databinding.ActivityWebViewBinding
import com.hjb.hwebview.utils.WebConstants
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WebViewActivity : AppCompatActivity() {
    lateinit var mDataBinding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding =
            DataBindingUtil.setContentView<ActivityWebViewBinding>(this, R.layout.activity_web_view)
        val url: String? = intent.getStringExtra(WebConstants.URL)
        val title: String? = intent.getStringExtra(WebConstants.TITLE)
        title?.length
        url?.run {
            mDataBinding.webview.loadUrl(this)
            mDataBinding.webview.webViewClient = WebViewClient()
        }
    }

}