package com.example.nasaimagesearchapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.screens.ImageListItem
import com.example.nasaimagesearchapp.ui.screens.SearchBar
import org.junit.Rule
import org.junit.Test

class ImageListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testImageListItem_Clickable() {
        val image = ImageModel("https://example.com/image.jpg",
            "Title 1",
            "Description 1",
            "2023-07-09")
        var clickedImage: ImageModel? = null

        composeTestRule.setContent {
            ImageListItem(image = image) {
                clickedImage = it
            }
        }

        // Perform a click on the ImageListItem
        composeTestRule.onNodeWithTag("ImageListItem").performClick()

        // Verify that the clickedImage is the expected image
        assert(clickedImage == image)
    }

    @Test
    fun testSearchBar_onSearchQueryChange() {
        val searchQuery = mutableStateOf("")

        composeTestRule.setContent {
            SearchBar(searchQuery = searchQuery) {}
        }

        // Find the BasicTextField
        val textField = composeTestRule.onNodeWithContentDescription("Search")

        // Enter text into the BasicTextField
        textField.performTextInput("pluto")

        // Verify that the searchQuery has been updated
        assert(searchQuery.value == "pluto")
    }
}
