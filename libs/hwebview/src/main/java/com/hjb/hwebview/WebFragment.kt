package com.hjb.hwebview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *
 * @ClassName:      WebFragment
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/31 17:42
 */

class WebFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web, null)
    }
}