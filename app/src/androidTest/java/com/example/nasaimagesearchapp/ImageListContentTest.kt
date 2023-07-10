package com.example.nasaimagesearchapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.screens.ImageListContent
import com.example.nasaimagesearchapp.ui.viewmodel.ImageViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class ImageListContentTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var mockViewModel: ImageViewModel

    @Before
    fun setup() {
        mockViewModel = Mockito.mock(ImageViewModel::class.java)
    }

    @Test
    fun testImageListContent_DisplayedItems() {
        val mockImages = MutableLiveData<List<ImageModel>>().apply {
            listOf(
                ImageModel("image1", "Title 1", "Description 1", "2023-07-07"),
                ImageModel("image2", "Title 2", "Description 2", "2023-07-08"),
                ImageModel("image3", "Title 3", "Description 3", "2023-07-09")
            )
        }
        Mockito.`when`(mockViewModel.images).thenReturn(mockImages)

        composeTestRule.setContent {
            ImageListContent(viewModel = mockViewModel, navigateToImageModel = {})
        }

        composeTestRule.onNodeWithText("Title 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Description 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Title 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Description 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Title 3").assertIsDisplayed()
        composeTestRule.onNodeWithText("Description 3").assertIsDisplayed()
    }

    @Test
    fun testImageListContent_SearchBar() {
        val mockImages = MutableLiveData<List<ImageModel>>().apply {
            listOf(
                ImageModel("image1", "Title 1", "Description 1", "2023-07-07"),
                ImageModel("image2", "Title 2", "Description 2", "2023-07-08")
            )
        }
        Mockito.`when`(mockViewModel.images).thenReturn(mockImages)

        composeTestRule.setContent {
            ImageListContent(viewModel = mockViewModel, navigateToImageModel = {})
        }

        composeTestRule.onNodeWithTag("Search").assertIsDisplayed()
    }
}
