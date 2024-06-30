package com.hjb.androidcodereview.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hjb.androidcodereview.App
import com.hjb.androidcodereview.entity.Book

import com.hjb.androidcodereview.myApplication

/**
 *
 * @ClassName:      SQLDatabase
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/14 5:12 PM
 */
@Database(entities = [Book::class], version = 1)
abstract class AppDataDB : RoomDatabase() {
    abstract fun book(): BookDao

    companion object {
        val INSTANCE = InstanceHelper.singleInstance
    }

    object InstanceHelper {
        var singleInstance = Room.databaseBuilder(
            myApplication,
            AppDataDB::class.java, "dhsajdhajdhaj.db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}