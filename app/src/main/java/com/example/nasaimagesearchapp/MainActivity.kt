package com.example.nasaimagesearchapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.data.repository.FetchAPIData
import com.example.nasaimagesearchapp.ui.screens.ImageListContent
import com.example.nasaimagesearchapp.ui.theme.MyTheme
import com.example.nasaimagesearchapp.ui.viewmodel.ImageViewModel
import com.example.nasaimagesearchapp.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Making API calls using MVVM Architecture
        val fetchAPIData = FetchAPIData()
        imageViewModel = ViewModelProvider(this, ViewModelFactory(fetchAPIData)).get(ImageViewModel::class.java)
        imageViewModel.fetchImages()

        setContent {
            MyTheme {
                MyApp (
                    imageViewModel = imageViewModel,
                    navigateToImageModel = { imageModel ->
                        startActivity(NASAItemActivity.newIntent(this, imageModel))
                    }
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(imageViewModel: ImageViewModel, navigateToImageModel: (ImageModel) -> Unit) {
    Scaffold(
        content = {
            ImageListContent(imageViewModel, navigateToImageModel = navigateToImageModel)
        }
    )
}