package com.quyunshuo.wanandroid.home.bean

import com.google.gson.annotations.SerializedName

/**
 * 获取文章数据的当前页的额外数据
 *
 * @property curPage Int 当前页
 * @property articleList MutableList<ArticleBean> 文章列表
 * @property offset Int
 * @property over Boolean 是否结束
 * @property pageCount Int 文章总页数
 * @property size Int 列表长度
 * @property total Int 总文章数
 *
 * @author Qu Yunshuo
 * @since 2021/8/11 1:00 上午
 */
data class ArticlePageBean(
    val curPage: Int,
    @SerializedName("datas") val articleList: MutableList<ArticleBean>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)
