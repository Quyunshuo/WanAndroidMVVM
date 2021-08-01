package com.quyunshuo.wanandroid.home

import androidx.fragment.app.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseFragment
import com.quyunshuo.wanandroid.home.databinding.HomeFragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页Fragment
 *
 * @author Qu Yunshuo
 * @since 2021/8/1 11:46 下午
 */
@AndroidEntryPoint
@Route(path = RouteUrl.Home.HomeFragment)
class HomeFragment : BaseFragment<HomeFragmentHomeBinding, EmptyViewModel>() {

    override val mViewModel: EmptyViewModel by viewModels()

    override fun HomeFragmentHomeBinding.initView() {}

    override fun initObserve() {}

    override fun initRequestData() {}
}