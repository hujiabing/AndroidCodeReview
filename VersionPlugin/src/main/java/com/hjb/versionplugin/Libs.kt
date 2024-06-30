package com.hjb.versionplugin

/**
 * @author= ning.wang
 * @date= 2022-04-01 6:57 下午
 * @desc= 依赖包和版本号
 */
object AndroidX {

    const val core_ktx = "androidx.core:core-ktx:1.10.1"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val multidex = "androidx.multidex:multidex:2.0.1"
    const val androidXAnnotation = "androidx.annotation:annotation:1.6.0"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.3.0"
    const val appcompat = "androidx.appcompat:appcompat:1.6.1"

    private const val lifecycle_Version = "2.6.1"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata:$lifecycle_Version"
    const val lifecycle_livedata_ktx =
        "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_Version"
    const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_Version"
    const val lifecycle_viewmodel_ktx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_Version"
    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_Version"
    const val lifecycle_service = "androidx.lifecycle:lifecycle-service:$lifecycle_Version"
    const val lifecycle_process = "androidx.lifecycle:lifecycle-process:$lifecycle_Version"
    const val datastore_preferences = "androidx.datastore:datastore-preferences:1.0.0"
    val lifecycleDependencies = arrayOf(
        lifecycle_livedata,
        lifecycle_livedata_ktx,
        lifecycle_runtime_ktx,
        lifecycle_viewmodel_ktx,
        lifecycle_viewmodel,
        lifecycle_service,
        lifecycle_process
    )
    val baseDependencies = arrayOf(
        core_ktx,
        appcompat,
        multidex,
        androidXAnnotation
    )
}

object Google {
    const val autoService = "com.google.auto.service:auto-service:1.0.1"
    const val material = "com.google.android.material:material:1.9.0"
}

object Coroutines {
    private const val coroutinesVersion = "1.7.1"
    const val kotlinx_coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val kotlinx_coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    val coroutinesDependencies = arrayOf(
        kotlinx_coroutines_core,
        kotlinx_coroutines_android,
    )

}

object RxJava {
    const val rxjava = "io.reactivex.rxjava3:rxjava:3.1.6"
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:3.0.2"
    val rxJavaDependencies = arrayOf(
        rxjava,
        rxandroid,
    )
}

object Room {
    const val room_version = "2.5.0"
    const val room_runtime = "androidx.room:room-runtime:$room_version"
    const val room_compiler = "androidx.room:room-compiler:$room_version"
    const val room_ktx = "androidx.room:room-ktx:$room_version"
    val roomDependencies = arrayOf(
        room_runtime,
        room_ktx,
    )
}

object Retrofit {
    const val okhttpVersion = "4.11.0"
    const val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"

    val retrofitDependencies = arrayOf(
        okhttp,
        logging_interceptor,
        retrofit
    )
}

object Libs {
    const val fastjson = "com.alibaba:fastjson:1.2.83"
    const val strictDatabinding = "com.kunminx.arch:strict-databinding:5.6.0"
    const val unPeekLivedata = "com.kunminx.arch:unpeek-livedata:7.8.0"
    const val MMKV = "com.tencent:mmkv:1.2.16" ///快速存储 不重要可以丢失的数据用这个
    const val glideVersion = "4.15.1"
    const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    const val glide_annotations = "com.github.bumptech.glide:annotations:$glideVersion"
    const val glide_compiler = "com.github.bumptech.glide:compiler:$glideVersion"
}

