package com.gorkem.halfiyatlar.service

import com.gorkem.halfiyatlar.util.Constants.BASE_URL

object ApiUtils {
    fun getHeadersInfo(): HeadersInfo{
        return RetrofitClient.getClient(BASE_URL)
            .create(HeadersInfo::class.java)
    }
}