package com.example.nasaimagesearchapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nasaimagesearchapp.data.MockDataProvider
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.ImageListItem
import com.example.nasaimagesearchapp.ui.SearchBar

@Composable
fun ImageListContent(navigateToImageModel: (ImageModel) -> Unit) {
    val images = remember { MockDataProvider.imageList }


    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(modifier = Modifier.fillMaxWidth())
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
}