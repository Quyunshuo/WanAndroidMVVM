package com.quyunshuo.wanandroid.main.ui.activity

import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.quyunshuo.wanandroid.common.constant.RouteUrl
import com.quyunshuo.wanandroid.common.ui.BaseActivity
import com.quyunshuo.wanandroid.main.R
import com.quyunshuo.wanandroid.main.adapter.ViewPagerAdapter
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

    /**
     * ViewPager适配器
     */
    private val mVPAdapter by lazy(mode = LazyThreadSafetyMode.NONE) {
        ViewPagerAdapter(this, mViewModel.fragments)
    }

    companion object {
        const val INDEX_HOME = 0
        const val INDEX_SUBSCRIBE_ACCOUNT = 1
        const val INDEX_ME = 2
    }

    override fun MainActivityMainBinding.initView() {
        // 底部导航栏设置
        vBottomNavigationView.run {
            itemIconTintList = null
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.vNavHome -> vViewPager.currentItem = INDEX_HOME
                    R.id.vNavSubscribeAccount -> vViewPager.currentItem = INDEX_SUBSCRIBE_ACCOUNT
                    R.id.vNavMe -> vViewPager.currentItem = INDEX_ME
                }
                true
            }
        }
        // ViewPager2设置
        vViewPager.run {
            adapter = mVPAdapter
            offscreenPageLimit = 3
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    val menu = vBottomNavigationView.menu
                    when (position) {
                        INDEX_HOME -> menu.getItem(INDEX_HOME).isChecked = true
                        INDEX_SUBSCRIBE_ACCOUNT ->
                            menu.getItem(INDEX_SUBSCRIBE_ACCOUNT).isChecked = true
                        INDEX_ME -> menu.getItem(INDEX_ME).isChecked = true
                    }
                }
            })

        }
    }

    override fun initObserve() {}

    override fun initRequestData() {}
}