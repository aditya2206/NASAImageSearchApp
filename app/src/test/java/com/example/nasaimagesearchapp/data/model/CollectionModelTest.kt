package com.example.nasaimagesearchapp.data.model

import com.example.nasaimagesearchapp.data.model.CollectionModel
import com.example.nasaimagesearchapp.data.model.CollectionsLinksModel
import com.example.nasaimagesearchapp.data.model.DataModel
import com.example.nasaimagesearchapp.data.model.ItemsModel
import org.junit.Assert.assertEquals
import org.junit.Test

class CollectionModelTest {

    @Test
    fun `CollectionModel should have correct properties`() {
        // Given
        val version = "1.0"
        val href = "https://example.com/collection"
        val items = listOf(
            ItemsModel(listOf(DataModel("Title 1", "Description 1", "07/09")), listOf()),
            ItemsModel(listOf(DataModel("Title 2", "Description 2", "07/09")), listOf()),
            ItemsModel(listOf(DataModel("Title 3", "Description 3", "07/09")), listOf())
        )
        val links = listOf(
            CollectionsLinksModel("Link 1"),
            CollectionsLinksModel("Link 2"),
            CollectionsLinksModel("Link 3")
        )

        // When
        val collectionModel = CollectionModel(version, href, items, links)

        // Then
        assertEquals(version, collectionModel.version)
        assertEquals(href, collectionModel.href)
        assertEquals(items, collectionModel.items)
        assertEquals(links, collectionModel.links)
    }
}
