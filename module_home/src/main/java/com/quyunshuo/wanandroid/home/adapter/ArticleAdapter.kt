package com.quyunshuo.wanandroid.home.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.quyunshuo.wanandroid.home.R
import com.quyunshuo.wanandroid.home.bean.ArticleBean
import javax.inject.Inject

/**
 * 文章列表适配器
 *
 * @author Qu Yunshuo
 * @since 2021/8/16 11:26 下午
 */
class ArticleAdapter @Inject constructor() :
    BaseQuickAdapter<ArticleBean, BaseViewHolder>(R.layout.home_item_article), LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: ArticleBean) {
        // 是否置顶文章
        if (item.top == true) {
            holder.setVisible(R.id.vTopTv, true)
        } else {
            holder.setGone(R.id.vTopTv, true)
        }
        // 设置作者
        holder.setText(
            R.id.vAuthorTv,
            if (item.author.isNullOrEmpty()) item.shareUser else item.author
        )
        // 设置标题
        holder.setText(R.id.vTitleTv, item.title)
        // 时间
        holder.setText(R.id.vDateTv, item.niceDate ?: item.niceShareDate ?: "")
        // 设置分类章节
        holder.setText(R.id.vChapterTv, "${item.superChapterName}-${item.chapterName}")
    }
}