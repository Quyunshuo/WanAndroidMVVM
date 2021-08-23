package com.quyunshuo.wanandroid.home.bean

/**
 * 文章数据类
 *
 * @property apkLink String?
 * @property audit Int?
 * @property author String? 作者
 * @property canEdit Boolean?
 * @property chapterId Int?
 * @property chapterName String?
 * @property collect Boolean?
 * @property courseId Int?
 * @property desc String?
 * @property descMd String?
 * @property envelopePic String?
 * @property fresh Boolean?
 * @property host String?
 * @property id Int?
 * @property link String 文章链接
 * @property niceDate String?
 * @property niceShareDate String?
 * @property origin String?
 * @property prefix String?
 * @property projectLink String?
 * @property publishTime Long?
 * @property realSuperChapterId Int?
 * @property selfVisible Int?
 * @property shareDate Long?
 * @property shareUser String? 分享人
 * @property superChapterId Int?
 * @property superChapterName String? 一级分类的名称
 * @property tags List<Tag>?
 * @property title String 文章标题
 * @property type Int?
 * @property userId Int?
 * @property visible Int?
 * @property zan Int?
 * @property top Boolean? 是否置顶 自定义属性
 *
 * 示例:
 * ```
 * {
 *     "apkLink": "",
 *     "audit": 1,
 *     "author": "扔物线",
 *     "canEdit": false,
 *     "chapterId": 249,
 *     "chapterName": "干货资源",
 *     "collect": false,
 *     "courseId": 13,
 *     "desc": "",
 *     "descMd": "",
 *     "envelopePic": "",
 *     "fresh": true,
 *     "host": "",
 *     "id": 12554,
 *     "link": "https://mp.weixin.qq.com/s/I8cI2SOBazsM8sdDWCchLw",
 *     "niceDate": "13小时前",
 *     "niceShareDate": "2020-03-23 16:36",
 *     "origin": "",
 *     "prefix": "",
 *     "projectLink": "",
 *     "publishTime": 1628563792000,
 *     "realSuperChapterId": 248,
 *     "selfVisible": 0,
 *     "shareDate": 1584952597000,
 *     "shareUser": "",
 *     "superChapterId": 249,
 *     "superChapterName": "干货资源",
 *     "tags": [],
 *     "title": "LiveData：还没普及就让我去世？我去你的 Kotlin 协程",
 *     "type": 1,
 *     "userId": -1,
 *     "visible": 1,
 *     "zan": 0
 * }
 * ```
 *
 * @author Qu Yunshuo
 * @since 2021/8/11 12:41 上午
 */
data class ArticleBean(
    val apkLink: String?,
    val audit: Int?,
    val author: String?,
    val canEdit: Boolean?,
    val chapterId: Int?,
    val chapterName: String?,
    val collect: Boolean?,
    val courseId: Int?,
    val desc: String?,
    val descMd: String?,
    val envelopePic: String?,
    val fresh: Boolean?,
    val host: String?,
    val id: Int?,
    val link: String,
    val niceDate: String?,
    val niceShareDate: String?,
    val origin: String?,
    val prefix: String?,
    val projectLink: String?,
    val publishTime: Long?,
    val realSuperChapterId: Int?,
    val selfVisible: Int?,
    val shareDate: Long?,
    val shareUser: String?,
    val superChapterId: Int?,
    val superChapterName: String?,
    val tags: List<Tag>?,
    val title: String,
    val type: Int?,
    val userId: Int?,
    val visible: Int?,
    val zan: Int?,
    var top: Boolean?
) {
    data class Tag(
        val name: String,
        val url: String
    )
}