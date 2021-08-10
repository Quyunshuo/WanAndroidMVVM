package com.quyunshuo.wanandroid.home.adapter

import android.widget.ImageView
import coil.load
import com.quyunshuo.wanandroid.home.R
import com.quyunshuo.wanandroid.home.bean.BannerBean
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

/**
 * 首页Banner适配器
 *
 * @author Qu Yunshuo
 * @since 2021/8/6 12:14 上午
 */
class BannerAdapter : BaseBannerAdapter<BannerBean>() {
    override fun bindData(
        holder: BaseViewHolder<BannerBean>,
        data: BannerBean,
        position: Int,
        pageSize: Int
    ) {
        holder.itemView
            .findViewById<ImageView>(R.id.vBannerIv)
            .load(data.imagePath)
    }

    override fun getLayoutId(viewType: Int): Int = R.layout.home_item_banner
}