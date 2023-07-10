package com.example.nasaimagesearchapp.data.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class DataModelTest {

    @Test
    fun `DataModel should have correct properties`() {
        // Given
        val title = "Title 1"
        val description = "Description 1"
        val dateCreated = "2023-07-09"

        // When
        val dataModel = DataModel(title, description, dateCreated)

        // Then
        assertEquals(title, dataModel.title)
        assertEquals(description, dataModel.description)
        assertEquals(dateCreated, dataModel.date_created)
    }
}