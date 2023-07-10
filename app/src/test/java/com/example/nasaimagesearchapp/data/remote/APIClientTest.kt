package com.example.nasaimagesearchapp.data.remote

import com.example.nasaimagesearchapp.data.service.APIService
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock

class APIClientTest {

    @Test
    fun `apiService should be an instance of APIService`() {
        // Given
        val mockApiService = mock(APIService::class.java)

        // When
        val apiService = APIClient.apiService

        // Then
        assertTrue(apiService is APIService)
    }
}