package com.quyunshuo.wanandroid.home.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.quyunshuo.wanandroid.base.mvvm.vm.BaseViewModel
import com.quyunshuo.wanandroid.base.utils.toast
import com.quyunshuo.wanandroid.home.bean.BannerBean
import com.quyunshuo.wanandroid.home.ui.repo.HomeFragmentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * HomeFragment 的 VM 层
 *
 * @author Qu Yunshuo
 * @since 2021/8/5 11:11 下午
 */
@HiltViewModel
class HomeFragmentVM @Inject constructor(private val mRepo: HomeFragmentRepo) : BaseViewModel() {
    /**
     * banner 数据
     */
    val bannersLD = MutableLiveData<List<BannerBean>>()

    /**
     * 获取 banner 数据
     */
    fun getBanners() {
        viewModelScope.launch(Dispatchers.IO) {
            mRepo.getBanners()
                .catch { toast(it.message ?: "") }
                .collect { bannersLD.postValue(it) }
        }
    }
}