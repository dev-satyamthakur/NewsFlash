package com.satyamthakur.newsflash.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.satyamthakur.newsflash.BuildConfig

@Composable
fun HomeScreen() {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("This is Home Screen")
    }

}