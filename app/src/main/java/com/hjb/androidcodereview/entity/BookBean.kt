package com.hjb.androidcodereview.entity

import kotlin.properties.Delegates

/**
 *
 * @ClassName:      BookBean
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/20 16:42
 */
open class BookBean constructor(private var name: String = "") {
//主构造函数如果都有默认值那么会自动生产一个无参构造

    var age by Delegates.notNull<Int>()
}