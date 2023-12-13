package com.satyamthakur.newsflash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.satyamthakur.newsflash.ui.components.AppNavigationGraph
import com.satyamthakur.newsflash.ui.theme.NewsFlashTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsFlashTheme {
                Surface {
//                    AppEntryPoint()
                    Text("Hello, World")
                }

            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}

