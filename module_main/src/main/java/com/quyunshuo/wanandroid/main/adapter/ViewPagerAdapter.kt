package com.quyunshuo.wanandroid.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * ViewPager适配器
 *
 * @author Qu Yunshuo
 * @since 2021/8/2 12:41 上午
 */
class ViewPagerAdapter(fa: FragmentActivity, private val fragments: List<Fragment>) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}