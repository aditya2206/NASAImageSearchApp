package com.example.nasaimagesearchapp.data

import com.example.nasaimagesearchapp.data.model.ImageModel

object MockDataProvider {

    val image =
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 1",
            description = "This is a Test Image",
            date_created = "08/07"
        )

    val imageList = listOf(
        image,
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 2",
            description = "This is a Test Image",
            date_created = "08/07"
        ),
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 3",
            description = "This is a Test Image",
            date_created = "08/07"
        ),
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 3",
            description = "This is a Test Image",
            date_created = "08/07"
        ),
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 4",
            description = "This is a Test Image",
            date_created = "08/07"
        ),
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 5",
            description = "This is a Test Image",
            date_created = "08/07"
        ),
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 6",
            description = "This is a Test Image",
            date_created = "08/07"
        ),
        ImageModel(
            imageUrl = "https://images-assets.nasa.gov/image/NHQ201906010007/NHQ201906010007~thumb.jpg",
            title = "Nasa Image 7",
            description = "This is a Test Image",
            date_created = "08/07"
        ),
    )
}