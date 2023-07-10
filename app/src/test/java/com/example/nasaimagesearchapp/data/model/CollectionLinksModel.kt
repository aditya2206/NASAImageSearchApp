package com.example.nasaimagesearchapp.data.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class CollectionsLinksModelTest {

    @Test
    fun `CollectionsLinksModel should have correct href`() {
        // Given
        val href = "https://example.com/collections"

        // When
        val collectionsLinksModel = CollectionsLinksModel(href)

        // Then
        assertEquals(href, collectionsLinksModel.href)
    }
}