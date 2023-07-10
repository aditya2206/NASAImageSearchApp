package com.example.nasaimagesearchapp.data.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ImageModelTest {

    @Test
    fun `ImageModel should have correct properties`() {
        // Given
        val imageUrl = "https://example.com/image.jpg"
        val title = "Title 1"
        val description = "Description 1"
        val dateCreated = "2023-07-09"

        // When
        val imageModel = ImageModel(imageUrl, title, description, dateCreated)

        // Then
        assertEquals(imageUrl, imageModel.imageUrl)
        assertEquals(title, imageModel.title)
        assertEquals(description, imageModel.description)
        assertEquals(dateCreated, imageModel.date_created)
    }
}