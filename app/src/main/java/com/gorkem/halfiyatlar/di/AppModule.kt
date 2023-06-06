package com.gorkem.halfiyatlar.di

import com.gorkem.halfiyatlar.data.repository.BazaarRepo
import com.gorkem.halfiyatlar.service.ApiUtils
import com.gorkem.halfiyatlar.service.HeadersInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideBazaarRepo(bRepo:HeadersInfo): BazaarRepo{
        return BazaarRepo(bRepo)
    }

    @Provides
    @Singleton
    fun provideHeaderInfo(): HeadersInfo{
        return ApiUtils.getHeadersInfo()
    }
}