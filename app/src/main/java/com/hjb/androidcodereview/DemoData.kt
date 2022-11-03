package com.hjb.androidcodereview

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
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


    var name = ObservableField<String>("")

    var age = ObservableField<Int>(0)
    override fun toString(): String {
        return "DemoData(name=${name}, age=${age})"
    }


}