package com.satyamthakur.newsflash.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.satyamthakur.newsflash.BuildConfig
import com.satyamthakur.newsflash.ui.components.Loader
import com.satyamthakur.newsflash.ui.viewmodel.NewsViewmodel
import com.satyamthakur.utilities.ResourceState

@Composable
fun HomeScreen(
    newsViewmodel: NewsViewmodel = hiltViewModel()
) {

    val newsResponse by newsViewmodel.news.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (newsResponse) {
            is ResourceState.Loading -> {
                Loader()
                Log.d("MYAPPTAG", "Inside Loading")
            }

            is ResourceState.Success -> {
                Log.d("MYAPPTAG", "Inside Success")
                val response = (newsResponse as ResourceState.Success).data
                LazyColumn {
                    items(response.articles!!.size) {
                        Text(text = response.articles[it]!!.title.toString(),
                            modifier = Modifier.padding(8.dp))
                    }
                }
            }

            is ResourceState.Error -> {
                val error = newsResponse as ResourceState.Error
                Log.d("MYAPPTAG", "Inside Error $error")
            }
        }
    }

}