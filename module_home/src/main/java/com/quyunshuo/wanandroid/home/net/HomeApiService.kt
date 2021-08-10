package com.quyunshuo.wanandroid.home.net

import com.quyunshuo.wanandroid.common.bean.BaseResponse
import com.quyunshuo.wanandroid.home.bean.BannerBean
import retrofit2.http.GET

/**
 * 首页模块的接口代理类
 *
 * @author Qu Yunshuo
 * @since 2021/8/5 10:55 下午
 */
interface HomeApiService {

    /**
     * 获取首页Banner数据
     *
     * @return BaseResponse<List<BannerBean>> Banner列表
     */
    @GET("banner/json")
    suspend fun getBanners(): BaseResponse<List<BannerBean>>
}
