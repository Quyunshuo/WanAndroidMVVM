package com.quyunshuo.wanandroid.home.ui.repo

import com.quyunshuo.wanandroid.base.mvvm.m.BaseRepository
import com.quyunshuo.wanandroid.common.helper.responseCodeExceptionHandler
import com.quyunshuo.wanandroid.home.bean.ArticlePageBean
import com.quyunshuo.wanandroid.home.bean.BannerBean
import com.quyunshuo.wanandroid.home.net.HomeApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
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

    /**
     * 获取文章数据
     * @param page Int 分页加载的页码 从0开始
     * @return Flow<ArticlePageBean>
     */
    suspend fun getArticleData(page: Int) = request<ArticlePageBean> {
        // 如果页码为0 需要同步进行获取置顶文章进行合并
        if (page == 0) {
            val article: ArticlePageBean
            withContext(Dispatchers.IO) {
                // 开启 async 请求置顶文章
                val topArticleJob = async(Dispatchers.IO) {
                    mApi.getTopArticle().run {
                        responseCodeExceptionHandler(code, msg)
                        data
                    }
                }
                // 开启 async 请求文章
                val articleJob = async(Dispatchers.IO) {
                    mApi.getArticleByPage(page).run {
                        responseCodeExceptionHandler(code, msg)
                        data
                    }
                }
                // 合并两个请求的结果
                val topArticleList = topArticleJob.await()
                topArticleList.forEach { it.top = true }
                article = articleJob.await()
                topArticleList.addAll(article.articleList)
                article.articleList.clear()
                article.articleList.addAll(topArticleList)
            }
            emit(article)
        } else {
            mApi.getArticleByPage(page).run {
                responseCodeExceptionHandler(code, msg)
                emit(data)
            }
        }
    }
}