package com.quyunshuo.wanandroid.subscribeaccount

import androidx.fragment.app.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseFragment
import com.quyunshuo.wanandroid.subscribeaccount.databinding.SubscribeFragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 订阅号Fragment
 *
 * @author Qu Yunshuo
 * @since 2021/8/1 11:49 下午
 */
@AndroidEntryPoint
@Route(path = RouteUrl.SubscribeAccount.SubscribeAccountFragment)
class SubscribeAccountFragment : BaseFragment<SubscribeFragmentHomeBinding, EmptyViewModel>() {

    override val mViewModel: EmptyViewModel by viewModels()

    override fun SubscribeFragmentHomeBinding.initView() {}

    override fun initObserve() {}

    override fun initRequestData() {}
}