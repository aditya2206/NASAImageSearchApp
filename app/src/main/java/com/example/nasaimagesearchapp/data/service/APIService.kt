package com.example.nasaimagesearchapp.data.service

import com.example.nasaimagesearchapp.data.model.RootCollectionModel
import retrofit2.http.GET

interface APIService {
    @GET("search?q=pluto&media_type=image")
    suspend fun fetchData(): RootCollectionModel
}