package com.quyunshuo.wanandroid.home.ui.repo

import com.quyunshuo.wanandroid.base.mvvm.m.BaseRepository
import com.quyunshuo.wanandroid.common.helper.responseCodeExceptionHandler
import com.quyunshuo.wanandroid.home.bean.BannerBean
import com.quyunshuo.wanandroid.home.net.HomeApiService
import javax.inject.Inject

/**
 * HomeFragment的数据仓库层
 *
 * @author Qu Yunshuo
 * @since 2021/8/5 10:59 下午
 */
class HomeFragmentRepo @Inject constructor() : BaseRepository() {

    @Inject
    lateinit var mApi: HomeApiService

    /**
     * 获取首页Banner数据
     * @return Flow<List<BannerBean>> Banner数据
     */
    suspend fun getBanners() = request<List<BannerBean>> {
        mApi.getBanners().run {
            responseCodeExceptionHandler(code, msg)
            emit(data)
        }
    }
}