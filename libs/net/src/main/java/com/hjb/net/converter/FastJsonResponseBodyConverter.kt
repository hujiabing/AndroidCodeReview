package com.hjb.net.converter

import com.alibaba.fastjson.JSON
import okhttp3.ResponseBody
import retrofit2.Converter
import java.lang.reflect.Type

/**
 *
 * @ClassName:      FastJsonResponseBodyConverter
 * @Description:
 * @作者:         hujiabing
 * @日期:     2022/10/21 15:26
 */
class FastJsonResponseBodyConverter<T>(private val type: Type) : Converter<ResponseBody, T> {
    override fun convert(value: ResponseBody): T? {
        return value.use {
            JSON.parseObject(value.string(), type)
        }
    }
}