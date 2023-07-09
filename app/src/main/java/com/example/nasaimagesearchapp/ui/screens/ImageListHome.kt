package com.example.nasaimagesearchapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.viewmodel.ImageViewModel

    @Composable
    fun ImageListContent(viewModel: ImageViewModel, navigateToImageModel: (ImageModel) -> Unit) {

    //    This was added to provide mock data from the MockDataProvider
    //    val images = remember { MockDataProvider.imageList }
        val images: List<ImageModel> by viewModel.images.observeAsState(emptyList())
        val searchQuery = remember { mutableStateOf("") }

        LaunchedEffect(Unit) {
            viewModel.fetchImages()
        }

        Column(modifier = Modifier.fillMaxSize()) {
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                searchQuery = searchQuery,
                onSearchQueryChange = { query ->
                    searchQuery.value = query
                    viewModel.updateSearchQuery(query)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
            ) {
                items(
                    items = images,
                    itemContent = {
                        ImageListItem(image = it, navigateToImageModel)
                    }
                )
            }
        }

        LaunchedEffect(searchQuery.value) {
            viewModel.updateSearchQuery(searchQuery.value)
        }
    }