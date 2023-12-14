package com.satyamthakur.newsflash.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.satyamthakur.newsflash.ui.components.Loader
import com.satyamthakur.newsflash.ui.components.NewsRowComponent
import com.satyamthakur.newsflash.ui.viewmodel.NewsViewmodel
import com.satyamthakur.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewmodel: NewsViewmodel = hiltViewModel()
) {

    val newsResponse by newsViewmodel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->

        when (newsResponse) {
            is ResourceState.Loading -> {
                Loader()
                Log.d("MYAPPTAG", "Inside Loading")
            }

            is ResourceState.Success -> {
                Log.d("MYAPPTAG", "Inside Success")
                val response = (newsResponse as ResourceState.Success).data

                if (response.articles!!.isNotEmpty()) {
                    NewsRowComponent(page, response.articles[page]!!)
                }
            }

            is ResourceState.Error -> {
                val error = newsResponse as ResourceState.Error
                Log.d("MYAPPTAG", "Inside Error $error")
            }

        }
    }


}