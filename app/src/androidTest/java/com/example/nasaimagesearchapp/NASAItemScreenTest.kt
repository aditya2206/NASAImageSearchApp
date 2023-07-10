package com.example.nasaimagesearchapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.screens.NASAItemScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NASAItemScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<NASAItemActivity>()

    @Test
    fun testNASAItemScreen_ContentDisplayed() {
        // Create a sample ImageModel for testing
        val imageModel = ImageModel("image_url", "Title", "Description", "2023-07-07")

        // Launch the composable
        composeTestRule.setContent {
            NASAItemScreen(imageModel = imageModel)
        }

        // Assert that the content is displayed correctly
        composeTestRule.onNodeWithText("Title").assertIsDisplayed()
        composeTestRule.onNodeWithText("Description").assertIsDisplayed()
        composeTestRule.onNodeWithText("Creation Date").assertIsDisplayed()
    }
}

