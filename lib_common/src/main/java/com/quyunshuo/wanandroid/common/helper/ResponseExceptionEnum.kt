package com.quyunshuo.wanandroid.common.helper

/**
 * 请求响应异常的类型
 *
 * @author Qu Yunshuo
 * @since 2021/7/9 2:55 下午
 */
enum class ResponseExceptionEnum : ResponseExceptionEnumCode {

    NOT_LOGIN_ERROR {
        override fun getCode() = -1001
        override fun getMessage() = "未登录"
    },
    ERROR {
        override fun getCode() = -1
        override fun getMessage() = ""
    },
    SUCCESS {
        override fun getCode() = 0
        override fun getMessage() = ""
    }
}