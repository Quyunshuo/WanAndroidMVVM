package com.quyunshuo.wanandroid.main.ui.activity

import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseActivity
import com.quyunshuo.wanandroid.main.databinding.MainActivityMainBinding
import com.quyunshuo.wanandroid.main.ui.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * 首页
 *
 * @author Qu Yunshuo
 * @since 2021/7/28 9:50 下午
 */
@AndroidEntryPoint
@Route(path = RouteUrl.Main.MainActivity)
class MainActivity : BaseActivity<MainActivityMainBinding, MainViewModel>() {

    /**
     * MainActivity的ViewModel 通过Hilt自动注入
     */
    override val mViewModel: MainViewModel by viewModels()

    override fun MainActivityMainBinding.initView() {
        vBottomNavigationView.itemIconTintList = null
    }

    override fun initObserve() {}

    override fun initRequestData() {}
}