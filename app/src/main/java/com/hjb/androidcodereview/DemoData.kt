package com.hjb.androidcodereview

import android.widget.TextView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *
 * @ClassName:      DemoData
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/13 2:19 PM
 */
class DemoData : ViewModel() {

    var num = MutableLiveData<Int>(0)

    var name = ObservableField<String>("")

    var age = ObservableField<Int>(0)

    fun setText(owner: LifecycleOwner, textView: TextView) {
        textView.text = "${num.value}"
        num.observe(owner) { value ->
            textView.text = "$value"
        }

    }

    override fun toString(): String {
        return "DemoData(name=${name}, age=${age})"
    }


}