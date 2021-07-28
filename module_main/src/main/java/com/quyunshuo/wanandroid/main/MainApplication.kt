package com.quyunshuo.wanandroid.main

import android.app.Application
import android.content.Context
import com.google.auto.service.AutoService
import com.quyunshuo.wanandroid.base.app.ApplicationLifecycle
import com.quyunshuo.wanandroid.base.app.InitDepend

/**
 * Main模块的伪Application
 *
 * @author Qu Yunshuo
 * @since 2021/7/28 9:32 下午
 */
@AutoService(ApplicationLifecycle::class)
class MainApplication : ApplicationLifecycle {
    /**
     * 同[Application.attachBaseContext]
     * @param context Context
     */
    override fun onAttachBaseContext(context: Context) {}

    /**
     * 同[Application.onCreate]
     * @param application Application
     */
    override fun onCreate(application: Application) {}

    /**
     * 同[Application.onTerminate]
     * @param application Application
     */
    override fun onTerminate(application: Application) {}

    /**
     * 需要立即进行初始化的放在这里进行并行初始化
     * 需要必须在主线程初始化的放在[InitDepend.mainThreadDepends],反之放在[InitDepend.workerThreadDepends]
     * @return InitDepend 初始化方法集合
     */
    override fun initByFrontDesk(): InitDepend = InitDepend(mutableListOf(), mutableListOf())

    /**
     * 不需要立即初始化的放在这里进行后台初始化
     */
    override fun initByBackstage() {}
}