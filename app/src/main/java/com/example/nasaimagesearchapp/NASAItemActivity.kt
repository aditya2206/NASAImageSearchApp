package com.example.nasaimagesearchapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.screens.NASAItemScreen

class NASAItemActivity : ComponentActivity() {

    private val imageModel: ImageModel by lazy {
        intent?.getSerializableExtra(Image_ID) as ImageModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NASAItemScreen(imageModel)
        }
    }

    companion object {
        private const val Image_ID = "image_id"
        fun newIntent(context: Context, imageModel: ImageModel) =
            Intent(context, NASAItemActivity::class.java).apply {
                putExtra(Image_ID, imageModel)
            }
    }
}
