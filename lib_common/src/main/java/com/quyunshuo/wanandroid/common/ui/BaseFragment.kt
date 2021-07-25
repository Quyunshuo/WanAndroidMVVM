package com.quyunshuo.wanandroid.common.ui

import androidx.viewbinding.ViewBinding
import com.quyunshuo.wanandroid.base.mvvm.v.BaseFrameFragment
import com.quyunshuo.wanandroid.base.mvvm.vm.BaseViewModel

/**
 * Fragment基类
 *
 * @author Qu Yunshuo
 * @since 8/27/20
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : BaseFrameFragment<VB, VM>()