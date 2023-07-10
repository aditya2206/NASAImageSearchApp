package com.example.nasaimagesearchapp.data.model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class LinksModelTest {

    @Test
    fun `LinksModel should have correct href`() {
        // Given
        val href = "https://example.com/image.jpg"

        // When
        val linksModel = LinksModel(href)

        // Then
        assertEquals(href, linksModel.href)
    }
}