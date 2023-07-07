package com.example.nasaimagesearchapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.nasaimagesearchapp.data.remote.APIClient.apiService
import com.example.nasaimagesearchapp.data.model.ImageModel
import com.example.nasaimagesearchapp.ui.ImageListContent
import com.example.nasaimagesearchapp.ui.theme.MyTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            MyTheme {
                MyApp {
                    startActivity(NASAItemActivity.newIntent(this, it))
                }
            }
        }

        GlobalScope.launch {
            val result = apiService.fetchData();

            if(result != null){
                Log.d("Yo", result.collection.items.get(0).data.get(0).title)
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(navigateToImageModel: (ImageModel) -> Unit) {
    Scaffold(
        content = {
            ImageListContent(navigateToImageModel = navigateToImageModel)
        }
    )
}