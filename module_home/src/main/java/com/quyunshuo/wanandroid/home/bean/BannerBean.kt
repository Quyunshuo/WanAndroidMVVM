package com.quyunshuo.wanandroid.home.bean

/**
 * Banner数据
 *
 * @property desc String 简介
 * @property id Int id
 * @property imagePath String 图片地址
 * @property isVisible Int
 * @property order Int 顺序
 * @property title String 标题
 * @property type Int
 * @property url String 地址
 *
 * 示例:
 * ```
 * {
 *     "desc": "扔物线",
 *     "id": 29,
 *     "imagePath": "https://wanandroid.com/blogimgs/18320a47-148a-4f8e-bf1a-71e633872dcf.png",
 *     "isVisible": 1,
 *     "order": 0,
 *     "title": "Android 面试黑洞&mdash;&mdash;当我按下 Home 键再切回来，会发生什么？",
 *     "type": 0,
 *     "url": "https://www.bilibili.com/video/BV1CA41177Se"
 * }
 * ```
 *
 * @author Qu Yunshuo
 * @since 2021/8/5 11:35 下午
 */
data class BannerBean(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)