package com.gorkem.halfiyatlar.service

import com.gorkem.halfiyatlar.data.model.Bazaar
import com.gorkem.halfiyatlar.data.model.BazaarResult
import com.gorkem.halfiyatlar.data.repository.BazaarRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadersInfo {
    @GET("bazaar/single")
    fun getPrice(
        @Query("city")
        city: String?,
    ): Call<BazaarResult>
}