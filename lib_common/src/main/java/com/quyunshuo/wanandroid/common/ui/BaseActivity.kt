package com.quyunshuo.wanandroid.common.ui

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.quyunshuo.wanandroid.base.mvvm.v.BaseFrameActivity
import com.quyunshuo.wanandroid.base.mvvm.vm.BaseViewModel
import com.quyunshuo.wanandroid.base.utils.ActivityStackManager
import com.quyunshuo.wanandroid.base.utils.AndroidBugFixUtils

/**
 * Activity基类
 *
 * @author Qu Yunshuo
 * @since 8/27/20
 */
abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : BaseFrameActivity<VB, VM>() {

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "ActivityStack: ${ActivityStackManager.activityStack}")
    }

    override fun onDestroy() {
        super.onDestroy()
        // 解决某些特定机型会触发的Android本身的Bug
        AndroidBugFixUtils().fixSoftInputLeaks(this)
    }
}