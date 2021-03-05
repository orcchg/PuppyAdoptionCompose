package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.domain.Cat
import retrofit2.http.GET
import retrofit2.http.Query

interface Rest {

    @GET("images/search")
    suspend fun cats(
        @Query("size") size: String = "small",
        @Query("limit") limit: Int = 25
    ): List<Cat>
}
