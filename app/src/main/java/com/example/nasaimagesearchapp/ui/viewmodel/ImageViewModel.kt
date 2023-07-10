package com.example.nasaimagesearchapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.data.repository.FetchAPIData
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class ImageViewModel(private val fetchAPIData: FetchAPIData) : ViewModel() {

    private val _images = MutableLiveData<List<ImageModel>>(emptyList())
    val images: LiveData<List<ImageModel>> = _images

    private val _searchQuery = MutableLiveData<String>("")
    var searchQuery: String = _searchQuery.value.toString()

    fun fetchImages() {
        viewModelScope.launch {
            val fetchedData = fetchAPIData.fetchData(_searchQuery.value.toString())
            val transformedData = fetchedData.collection.items.flatMap { itemsMap ->
                val dataList = itemsMap.data
                val linksList  = itemsMap.links

                if(dataList.size == linksList.size) {
                    dataList.indices.map { index ->
                        val data = dataList[index]
                        val linkToImage = linksList[index]

                        val imageUrl = linkToImage.href
                        val title = data.title
                        val description = data.description
                        val date_created = data.date_created

                        ImageModel(imageUrl, title, description, date_created)
                    }
                } else {
                    emptyList()
                }
            }
            _images.value = transformedData
        }
    }

    private val searchQueryChannel = MutableSharedFlow<String>()

    init {
        viewModelScope.launch {
            searchQueryChannel
                .debounce(1000) // Added a debounce to reduce the number of API Calls
                .collectLatest { query ->
                    updateViewWithSearchQuery(query)
                }
        }
    }

    fun updateSearchQuery(query: String) {
        viewModelScope.launch {
            searchQuery = query
            searchQueryChannel.emit(query)
        }
    }

    private fun updateViewWithSearchQuery(query: String) {
        _searchQuery.value = query
        fetchImages()
    }
}

class ViewModelFactory(private val fetchAPIData: FetchAPIData) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageViewModel::class.java)) {
            return ImageViewModel(fetchAPIData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}