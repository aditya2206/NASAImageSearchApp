package com.example.nasaimagesearchapp.data

import com.example.nasaimagesearchapp.R
import com.example.nasaimagesearchapp.data.model.ImageModel

object MockDataProvider {

    val image =
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 1"
        )

    val imageList = listOf(
        image,
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 2"
        ),
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 3"
        ),
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 3"
        ),
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 4"
        ),
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 5"
        ),
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 6"
        ),
        ImageModel(
            imageUrl = R.drawable.nasa,
            title = "Nasa Image 7"
        ),
    )
}
