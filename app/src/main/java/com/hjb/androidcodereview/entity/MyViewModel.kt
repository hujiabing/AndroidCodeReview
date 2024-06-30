package com.hjb.androidcodereview.entity

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    var num = ObservableField<Int>(0)
}