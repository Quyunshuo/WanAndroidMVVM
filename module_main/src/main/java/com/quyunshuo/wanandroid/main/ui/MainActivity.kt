package com.quyunshuo.wanandroid.main.ui

import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseActivity
import com.quyunshuo.wanandroid.main.databinding.MainActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页
 *
 * @author Qu Yunshuo
 * @since 2021/7/28 9:50 下午
 */
@AndroidEntryPoint
@Route(path = RouteUrl.Main.MainActivity)
class MainActivity : BaseActivity<MainActivityMainBinding, EmptyViewModel>() {

    override val mViewModel: EmptyViewModel by viewModels()

    override fun MainActivityMainBinding.initView() {}

    override fun initObserve() {}

    override fun initRequestData() {}
}