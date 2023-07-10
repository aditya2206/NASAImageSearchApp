package com.example.nasaimagesearchapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nasaimagesearchapp.data.model.CollectionModel
import com.example.nasaimagesearchapp.data.model.CollectionsLinksModel
import com.example.nasaimagesearchapp.data.model.DataModel
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.data.model.ItemsModel
import com.example.nasaimagesearchapp.data.model.LinksModel
import com.example.nasaimagesearchapp.data.model.RootCollectionModel
import com.example.nasaimagesearchapp.data.repository.FetchAPIData
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ImageViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockFetchAPIData: FetchAPIData

    private lateinit var imageViewModel: ImageViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(TestCoroutineDispatcher())
        MockitoAnnotations.initMocks(this)
        imageViewModel = ImageViewModel(mockFetchAPIData)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchImages updates images LiveData with transformed data`() = runBlockingTest {
        // Given
        val testData = createTestData()
        `when`(mockFetchAPIData.fetchData("")).thenReturn(testData)

        // When
        imageViewModel.fetchImages()

        // Then
        val transformedData = transformTestData(testData)
        assertEquals(transformedData, imageViewModel.images.value)
    }

    @Test
    fun `updateSearchQuery updates searchQuery value`() = runBlockingTest {
        // Given
        val query = "pluto"

        // When
        imageViewModel.updateSearchQuery(query)

        // Then
        assertEquals(query, imageViewModel.searchQuery)
    }

    private fun createTestData(): RootCollectionModel {
        val data = DataModel("Image Title", "Image Description", "2023-07-06")
        val link = LinksModel("https://example.com/image.jpg")
        val item = ItemsModel(listOf(data), listOf(link))
        val collectionLinksModel = CollectionsLinksModel("https://example.com/image.jpg")
        val collection = CollectionModel("", "",listOf(item), listOf(collectionLinksModel))
        return RootCollectionModel(collection)
    }

    private fun transformTestData(testData: RootCollectionModel): List<ImageModel> {
        val items = testData.collection.items
        return items.flatMap { item ->
            val dataList = item.data
            val linksList = item.links

            dataList.indices.map { index ->
                val data = dataList[index]
                val link = linksList[index]

                val imageUrl = link.href
                val title = data.title
                val description = data.description
                val dateCreated = data.date_created

                ImageModel(imageUrl, title, description, dateCreated)
            }
        }
    }

}