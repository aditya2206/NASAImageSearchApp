package com.example.nasaimagesearchapp.data.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ItemsModelTest {

    @Test
    fun `ItemsModel should have correct properties`() {
        // Given
        val data = listOf(DataModel("Title 1", "Description 1", "2023-07-09"))
        val links = listOf(LinksModel("https://example.com/image.jpg"))

        // When
        val itemsModel = ItemsModel(data, links)

        // Then
        assertEquals(data, itemsModel.data)
        assertEquals(links, itemsModel.links)
    }
}