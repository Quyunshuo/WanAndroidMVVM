package com.quyunshuo.wanandroid.main.ui.vm

import com.quyunshuo.wanandroid.base.mvvm.vm.BaseViewModel
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
}