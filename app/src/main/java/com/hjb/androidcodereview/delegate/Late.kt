package com.hjb.androidcodereview.delegate

import kotlin.reflect.KProperty

/**
 *
 * @ClassName:      DelegateAttri
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/21 10:47
 */
class Late<T>(val block: () -> T) {
    var value: Any? = null

    operator fun getValue(any: Any?, kProperty: KProperty<*>): T {
        if (value == null) {
            value = block()
        }
        return value as T
    }
}