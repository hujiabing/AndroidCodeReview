package com.hjb.baselib.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "HAPPDataStore")

object DataStoreUtils {
    private lateinit var dataStore: DataStore<Preferences>

    fun init(context: Context): DataStoreUtils {
        dataStore = context.dataStore
        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getDataSync(key: String, default: T): T {
        val res = when (default) {
            is Boolean -> getBooleanData(key, default)
            is Int -> getIntData(key, default)
            is Long -> getLongData(key, default)
            is Double -> getDoubleData(key, default)
            is String -> getStringData(key, default)
            is Float -> getFloatData(key, default)
            else -> throw IllegalAccessException("类型错误")
        }
        return res as T
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getData(key: String, default: T): Flow<T> {
        val data = when (default) {
            is Boolean -> getBooleanFlow(key, default)
            is Int -> getIntFlow(key, default)
            is Long -> getLongFlow(key, default)
            is Double -> getDoubleFlow(key, default)
            is String -> getStringFlow(key, default)
            is Float -> getFloatFlow(key, default)
            else -> throw IllegalArgumentException("类型错误")
        }
        return data as Flow<T>
    }

    suspend fun <T> putData(key: String, value: T) {
        when (value) {
            is Boolean -> putBooleanData(key, value)
            is Int -> putIntData(key, value)
            is Long -> putLongData(key, value)
            is Double -> putDoubleData(key, value)
            is String -> putStringData(key, value)
            is Float -> putFloatData(key, value)
            else -> throw IllegalArgumentException("类型错误")
        }
    }

    fun <T> putDataSync(key: String, value: T) {
        when (value) {
            is Boolean -> putBooleanDataSync(key, value)
            is Int -> putIntDataSync(key, value)
            is Long -> putLongDataSync(key, value)
            is Double -> putDoubleDataSync(key, value)
            is String -> putStringDataSync(key, value)
            is Float -> putFloatDataSync(key, value)
            else -> throw IllegalArgumentException("类型错误")
        }
    }


    fun getBooleanFlow(key: String, default: Boolean = false): Flow<Boolean> =
        dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                it[booleanPreferencesKey(key)] ?: default
            }

    fun getBooleanData(key: String, default: Boolean = false): Boolean {
        var value = default
        runBlocking {
            dataStore.data.first {
                value = it[booleanPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    suspend fun putBooleanData(key: String, value: Boolean) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[booleanPreferencesKey(key)] = value
        }
    }

    fun putBooleanDataSync(key: String, value: Boolean) =
        runBlocking { putBooleanData(key, value) }

    fun getIntFlow(key: String, default: Int = 0): Flow<Int> =
        dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                it[intPreferencesKey(key)] ?: default
            }

    fun getIntData(key: String, default: Int = 0): Int {
        var value = default
        runBlocking {
            dataStore.data.first {
                value = it[intPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    suspend fun putIntData(key: String, value: Int) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[intPreferencesKey(key)] = value
        }
    }

    fun putIntDataSync(key: String, value: Int) =
        runBlocking { putIntData(key, value) }

    fun getFloatFlow(key: String, default: Float = 0f): Flow<Float> =
        dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                it[floatPreferencesKey(key)] ?: default
            }

    fun getFloatData(key: String, default: Float = 0f): Float {
        var value = default
        runBlocking {
            dataStore.data.first {
                value = it[floatPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    suspend fun putFloatData(key: String, value: Float) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[floatPreferencesKey(key)] = value
        }
    }

    fun putFloatDataSync(key: String, value: Float) =
        runBlocking { putFloatData(key, value) }


    fun getDoubleFlow(key: String, default: Double = 0.0): Flow<Double> =
        dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                it[doublePreferencesKey(key)] ?: default
            }

    fun getDoubleData(key: String, default: Double = 0.0): Double {
        var value = default
        runBlocking {
            dataStore.data.first {
                value = it[doublePreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    suspend fun putDoubleData(key: String, value: Double) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[doublePreferencesKey(key)] = value
        }
    }

    fun putDoubleDataSync(key: String, value: Double) =
        runBlocking { putDoubleData(key, value) }


    fun getStringFlow(key: String, default: String = ""): Flow<String> =
        dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                it[stringPreferencesKey(key)] ?: default
            }

    fun getStringData(key: String, default: String = ""): String {
        var value = default
        runBlocking {
            dataStore.data.first {
                value = it[stringPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    suspend fun putStringData(key: String, value: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[stringPreferencesKey(key)] = value
        }
    }

    fun putStringDataSync(key: String, value: String) =
        runBlocking { putStringData(key, value) }

    fun getLongFlow(key: String, default: Long = 0L): Flow<Long> =
        dataStore.data
            .catch {
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
                it[longPreferencesKey(key)] ?: default
            }

    fun getLongData(key: String, default: Long = 0L): Long {
        var value = default
        runBlocking {
            dataStore.data.first {
                value = it[longPreferencesKey(key)] ?: default
                true
            }
        }
        return value
    }

    suspend fun putLongData(key: String, value: Long) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[longPreferencesKey(key)] = value
        }
    }

    fun putLongDataSync(key: String, value: Long) =
        runBlocking { putLongData(key, value) }

    suspend fun clear() {
        dataStore.edit {
            it.clear()
        }
    }

    fun clearSync() {
        runBlocking {
            dataStore.edit {
                it.clear()
            }
        }
    }
}
