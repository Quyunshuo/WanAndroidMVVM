package com.quyunshuo.wanandroid.home.net

import com.quyunshuo.wanandroid.common.bean.BaseResponse
import com.quyunshuo.wanandroid.home.bean.ArticleBean
import com.quyunshuo.wanandroid.home.bean.ArticlePageBean
import com.quyunshuo.wanandroid.home.bean.BannerBean
import retrofit2.http.GET
import retrofit2.http.Path

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

    /**
     * 获取置顶文章
     * @return BaseResponse<MutableList<ArticleBean>> 置顶文章列表
     */
    @GET("article/top/json")
    suspend fun getTopArticle(): BaseResponse<MutableList<ArticleBean>>

    /**
     * 根据页面获取分页的文章数据
     * @param page Int 获取的文章页码 从 0 开始
     * @return BaseResponse<ArticlePageBean>
     */
    @GET("article/list/{page}/json")
    suspend fun getArticleByPage(@Path("page") page: Int): BaseResponse<ArticlePageBean>
}
