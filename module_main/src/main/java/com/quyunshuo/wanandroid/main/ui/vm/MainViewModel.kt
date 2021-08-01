package com.quyunshuo.wanandroid.main.ui.vm

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.quyunshuo.wanandroid.base.mvvm.vm.BaseViewModel
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.main.ui.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 首页VM层
 *
 * @author Qu Yunshuo
 * @since 2021/7/31 5:25 下午
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val mRepository: MainRepository) : BaseViewModel() {

    /**
     * 子页面集合
     */
    val fragments: List<Fragment> = listOf(
        ARouter.getInstance()
            .build(RouteUrl.Home.HomeFragment)
            .navigation() as Fragment,
        ARouter.getInstance()
            .build(RouteUrl.SubscribeAccount.SubscribeAccountFragment)
            .navigation() as Fragment,
        ARouter.getInstance()
            .build(RouteUrl.Me.MeFragment)
            .navigation() as Fragment
    )
}