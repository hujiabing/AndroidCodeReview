package com.hjb.androidcodereview.db

import androidx.room.*
import com.hjb.androidcodereview.entity.Book
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

/**
 *
 * @ClassName:      BookDao
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/14 5:14 PM
 */
@Dao
interface BookDao {
    @Query("select * from  Book")
    fun queryAll(): List<Book>

    @Query("select * from  Book where number = :id")
    fun queryById(id: Long): List<Book>

    @Insert
    fun insert(vararg book: Book): List<Long>

    @Insert
    fun insertList(books: List<Book>): List<Long>

    @Delete
    fun delete(book: Book): Int

    //删全部
    @Query("DELETE FROM Book")
    fun deleteAll()

    @Update
    fun update(book: Book): Int
}