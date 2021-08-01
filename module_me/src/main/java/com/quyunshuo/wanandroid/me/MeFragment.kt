package com.quyunshuo.wanandroid.me

import androidx.fragment.app.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseFragment
import com.quyunshuo.wanandroid.me.databinding.MeFragmentMeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 个人中心 和 更多 Fragment
 *
 * @author Qu Yunshuo
 * @since 2021/8/1 11:44 下午
 */
@AndroidEntryPoint
@Route(path = RouteUrl.Me.MeFragment)
class MeFragment : BaseFragment<MeFragmentMeBinding, EmptyViewModel>() {

    override val mViewModel: EmptyViewModel by viewModels()

    override fun MeFragmentMeBinding.initView() {}

    override fun initObserve() {}

    override fun initRequestData() {}
}