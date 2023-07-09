package com.example.nasaimagesearchapp.data.model

import java.io.Serializable

data class ImageModel(
    val imageUrl: String,
    val title: String,
    val description: String,
    val date_created: String
): Serializable
