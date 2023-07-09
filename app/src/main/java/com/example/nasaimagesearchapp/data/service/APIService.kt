package com.example.nasaimagesearchapp.data.service

import com.example.nasaimagesearchapp.data.model.RootCollectionModel
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("search")
    suspend fun fetchData(
        @Query("q") searchQuery: String,
        @Query("media_type") mediaType: String = "image"
    ): RootCollectionModel
}