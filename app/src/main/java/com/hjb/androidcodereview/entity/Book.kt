package com.hjb.androidcodereview.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @ClassName:      Book
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/14 5:15 PM
 */
@Entity
data class Book(
    @PrimaryKey
    var number: Long,
    var title: String
) {


    override fun toString(): String {
        return "Book(title='$title', number=$number)"
    }


}