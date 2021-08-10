package com.quyunshuo.wanandroid.home.ui.fragment

import androidx.fragment.app.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.base.ktx.observeLiveData
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseFragment
import com.quyunshuo.wanandroid.home.R
import com.quyunshuo.wanandroid.home.adapter.BannerAdapter
import com.quyunshuo.wanandroid.home.bean.BannerBean
import com.quyunshuo.wanandroid.home.databinding.HomeFragmentHomeBinding
import com.quyunshuo.wanandroid.home.ui.vm.HomeFragmentVM
import com.zhpan.bannerview.BannerViewPager
import dagger.hilt.android.AndroidEntryPoint

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

    override val mViewModel: HomeFragmentVM by viewModels()

    override fun HomeFragmentHomeBinding.initView() {
        mBannerViewPager = mBinding.root.findViewById(R.id.vBanner)
        mBannerViewPager.apply {
            adapter = mBannerAdapter
            setLifecycleRegistry(lifecycle)
        }
    }

    override fun initObserve() {
        observeLiveData(mViewModel.bannersLD, ::processBanners)
    }

    override fun initRequestData() {
        mViewModel.getBanners()
    }

    /**
     * 处理banner数据
     * @param banners List<BannerBean>
     */
    private fun processBanners(banners: List<BannerBean>) {
        mBannerViewPager.create()
        mBannerViewPager.refreshData(banners)
    }
}