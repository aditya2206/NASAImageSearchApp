package com.example.nasaimagesearchapp.data.model

data class CollectionModel(
    val version: String,
    val href: String,
    val items: List<ItemsModel>,
    val links: List<CollectionsLinksModel>
)
