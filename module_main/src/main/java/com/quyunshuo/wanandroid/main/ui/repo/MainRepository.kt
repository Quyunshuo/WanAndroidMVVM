package com.quyunshuo.wanandroid.main.ui.repo

import com.quyunshuo.wanandroid.base.mvvm.m.BaseRepository
import com.quyunshuo.wanandroid.main.net.MainApiService
import javax.inject.Inject

/**
 * 首页数据仓库
 *
 * @author Qu Yunshuo
 * @since 2021/7/31 5:18 下午
 */
class MainRepository @Inject constructor() : BaseRepository() {

    @Inject
    lateinit var mApi: MainApiService

}