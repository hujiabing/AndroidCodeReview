package com.hjb.login

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.hjb.baselib.autoservice.ILoginInterface


/**
 *
 * @ClassName:      LoginImpl
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/11/3 14:52
 */
@AutoService(ILoginInterface::class)
class LoginImpl : ILoginInterface {
    override fun startLoginActivity(context: Context) {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }
}