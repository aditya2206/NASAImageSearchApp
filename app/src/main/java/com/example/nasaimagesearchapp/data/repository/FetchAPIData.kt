package com.example.nasaimagesearchapp.data.repository

import com.example.nasaimagesearchapp.data.model.RootCollectionModel
import com.example.nasaimagesearchapp.data.remote.APIClient

class FetchAPIData {

    private val apiService = APIClient.apiService

    suspend fun fetchData(searchQuery: String): RootCollectionModel {
        return apiService.fetchData(searchQuery)
    }
}