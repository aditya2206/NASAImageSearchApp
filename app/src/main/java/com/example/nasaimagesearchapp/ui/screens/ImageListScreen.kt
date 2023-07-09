package com.example.nasaimagesearchapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.theme.cardBackground
import com.example.nasaimagesearchapp.ui.theme.typography

    @Composable
    fun ImageListItem(image: ImageModel, navigateToImageModel: (ImageModel) -> Unit,) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = cardBackground,
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        ) {
            Column(
                modifier = Modifier.clickable { navigateToImageModel(image) }
            ) {
                NASAImage(image)
                Text(
                    text = image.title,
                    style = typography.h6,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }

    @Composable
    private fun NASAImage(image: ImageModel) {
        SubcomposeAsyncImage(
            model = image.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
        )
    }

    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier,
        searchQuery: MutableState<String>,
        onSearchQueryChange: (String) -> Unit
    ) {
        TextField(
            value = searchQuery.value,
            onValueChange = onSearchQueryChange,
            modifier = modifier,
            label = { Text("Search") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true
        )
    }