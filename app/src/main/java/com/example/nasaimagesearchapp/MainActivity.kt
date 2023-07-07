package com.example.nasaimagesearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nasaimagesearchapp.data.remote.APIClient.apiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val result = apiService.fetchData();

            if(result != null){
                Log.d("Get First Item Description:", result.collection.items.get(0).data.get(0).title)
            }
        }
    }
}