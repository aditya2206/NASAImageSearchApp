package com.example.nasaimagesearchapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nasaimagesearchapp.data.MockDataProvider
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
    Image(
        painter = painterResource(id = image.imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
    )
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "Yo",
        onValueChange = { },
        modifier = modifier.padding(8.dp),
        placeholder = { Text(text = "Search") }
    )
}


@Preview
@Composable
fun PreviewImageItem() {
    val image = MockDataProvider.image
    ImageListItem(image = image, navigateToImageModel = {})
}