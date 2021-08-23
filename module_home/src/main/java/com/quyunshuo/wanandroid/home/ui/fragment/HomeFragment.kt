package com.quyunshuo.wanandroid.home.ui.fragment

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.base.ktx.observeLiveData
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseFragment
import com.quyunshuo.wanandroid.home.R
import com.quyunshuo.wanandroid.home.adapter.ArticleAdapter
import com.quyunshuo.wanandroid.home.adapter.BannerAdapter
import com.quyunshuo.wanandroid.home.bean.ArticleBean
import com.quyunshuo.wanandroid.home.bean.BannerBean
import com.quyunshuo.wanandroid.home.databinding.HomeFragmentHomeBinding
import com.quyunshuo.wanandroid.home.ui.vm.HomeFragmentVM
import com.zhpan.bannerview.BannerViewPager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * 首页Fragment
 *
 * @author Qu Yunshuo
 * @since 2021/8/1 11:46 下午
 */
@AndroidEntryPoint
@Route(path = RouteUrl.Home.HomeFragment)
class HomeFragment : BaseFragment<HomeFragmentHomeBinding, HomeFragmentVM>() {

    private lateinit var mBannerViewPager: BannerViewPager<BannerBean>

    private val mBannerAdapter = BannerAdapter()

    @Inject
    lateinit var articleAdapter: ArticleAdapter

    override val mViewModel: HomeFragmentVM by viewModels()

    override fun HomeFragmentHomeBinding.initView() {
        mBannerViewPager = mBinding.root.findViewById(R.id.vBanner)
        mBannerViewPager.apply {
            adapter = mBannerAdapter
            setLifecycleRegistry(lifecycle)
        }
        vArticleRv.apply {
            layoutManager = LinearLayoutManager(context)
        }
        // 文章适配器
        articleAdapter.apply {
            setOnItemClickListener { adapter, view, position -> }
        }
        vArticleRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
        }
    }

    override fun initObserve() {
        observeLiveData(mViewModel.bannersLD, ::processBanners)
        observeLiveData(mViewModel.articleListLD, ::processArticleData)
    }

    override fun initRequestData() {
        mViewModel.getBanners()
        mViewModel.getArticleData()
    }

    /**
     * 处理banner数据
     * @param banners List<BannerBean>
     */
    private fun processBanners(banners: List<BannerBean>) {
        mBannerViewPager.create()
        mBannerViewPager.refreshData(banners)
    }

    /**
     * 处理文章数据
     * @param articles MutableList<ArticleBean>
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun processArticleData(articles: MutableList<ArticleBean>) {
        if (articleAdapter.data === articles) {
            articleAdapter.notifyDataSetChanged()
        } else {
            articleAdapter.setNewInstance(articles)
        }
    }
}