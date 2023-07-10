package com.example.nasaimagesearchapp.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

class RootCollectionModelTest {

    @Test
    fun `RootCollectionModel should have correct collection`() {
        // Given
        val collection = CollectionModel("version", "https://example.com", emptyList(), emptyList())

        // When
        val rootCollectionModel = RootCollectionModel(collection)

        // Then
        assertEquals(collection, rootCollectionModel.collection)
    }
}
