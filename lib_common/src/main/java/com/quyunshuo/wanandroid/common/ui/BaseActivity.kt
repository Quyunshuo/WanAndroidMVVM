package com.quyunshuo.wanandroid.common.ui

import android.util.Log
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.jaeger.library.StatusBarUtil
import com.quyunshuo.wanandroid.base.mvvm.v.BaseFrameActivity
import com.quyunshuo.wanandroid.base.mvvm.vm.BaseViewModel
import com.quyunshuo.wanandroid.base.utils.ActivityStackManager
import com.quyunshuo.wanandroid.base.utils.AndroidBugFixUtils
import com.quyunshuo.wanandroid.common.R

/**
 * Activity基类
 *
 * @author Qu Yunshuo
 * @since 8/27/20
 */
abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : BaseFrameActivity<VB, VM>() {

    /**
     * 设置状态栏
     * 子类需要自定义时重写该方法即可
     * @return Unit
     */
    override fun setStatusBar() {
        val themeColor = ContextCompat.getColor(this, R.color.common_theme)
        StatusBarUtil.setColor(this, themeColor, 0)
    }

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