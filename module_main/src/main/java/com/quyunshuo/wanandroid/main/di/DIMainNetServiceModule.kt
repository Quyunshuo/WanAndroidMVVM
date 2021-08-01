package com.quyunshuo.wanandroid.main.di

import com.quyunshuo.wanandroid.main.net.MainApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * 全局作用域的Main模块网络接口代理依赖注入模块
 *
 * @author Qu Yunshuo
 * @since 2021/7/31 5:21 下午
 */
@Module
@InstallIn(SingletonComponent::class)
class DIMainNetServiceModule {

    /**
     * Main模块的[MainApiService]依赖提供方法
     *
     * @param retrofit Retrofit 自动注入的Retrofit实例
     * @return MainApiService
     */
    @Singleton
    @Provides
    fun provideMainApiService(retrofit: Retrofit): MainApiService {
        return retrofit.create(MainApiService::class.java)
    }
}