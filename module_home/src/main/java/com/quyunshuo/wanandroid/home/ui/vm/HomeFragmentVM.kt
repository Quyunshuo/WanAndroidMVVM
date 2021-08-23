package com.quyunshuo.wanandroid.home.ui.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.quyunshuo.wanandroid.base.mvvm.vm.BaseViewModel
import com.quyunshuo.wanandroid.base.utils.toast
import com.quyunshuo.wanandroid.home.bean.ArticleBean
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
     * 当前已获取的文章页码
     */
    private var mCurrArticlePage = 0

    /**
     * banner 数据
     */
    val bannersLD = MutableLiveData<List<BannerBean>>()

    /**
     * 文章列表数据源
     */
    val articleListLD = MutableLiveData<MutableList<ArticleBean>>()

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

    /**
     * 获取文章数据
     */
    fun getArticleData() {
        viewModelScope.launch(Dispatchers.IO) {
            mRepo.getArticleData(mCurrArticlePage)
                .catch {
                    Log.d("qqq", "catch: $it.message")
                }
                .collect {
                    val list = articleListLD.value ?: mutableListOf()
                    list.addAll(it.articleList)
                    articleListLD.postValue(list)
                    mCurrArticlePage = it.curPage
                    Log.d("qqq", "getArticleData: $it.")
                }
        }
    }
}