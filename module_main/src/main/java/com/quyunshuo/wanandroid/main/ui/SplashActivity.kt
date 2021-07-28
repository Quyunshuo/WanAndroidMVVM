package com.quyunshuo.wanandroid.main.ui

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.launcher.ARouter
import com.quyunshuo.wanandroid.base.mvvm.vm.EmptyViewModel
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseActivity
import com.quyunshuo.wanandroid.main.databinding.MainActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.jessyan.autosize.internal.CancelAdapt

/**
 * 启动页
 *
 * @author Qu Yunshuo
 * @since 2021/7/28 9:47 下午
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity<MainActivitySplashBinding, EmptyViewModel>(), CancelAdapt {

    override val mViewModel: EmptyViewModel by viewModels()

    /**
     * 初始化View
     */
    override fun MainActivitySplashBinding.initView() {
        lifecycleScope.launch(Dispatchers.Default) {
            delay(1500)
            ARouter.getInstance()
                .build(RouteUrl.Main.MainActivity)
                .navigation()
            delay(200)
            finish()
        }
    }

    /**
     * 订阅LiveData
     */
    override fun initObserve() {}

    /**
     * 用于在页面创建时进行请求接口
     */
    override fun initRequestData() {}

    override fun setStatusBar() {}
}