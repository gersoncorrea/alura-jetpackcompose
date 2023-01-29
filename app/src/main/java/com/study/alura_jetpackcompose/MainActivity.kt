package com.study.alura_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.study.alura_jetpackcompose.sampledata.sampleProducts
import com.study.alura_jetpackcompose.ui.screens.HomeScreen
import com.study.alura_jetpackcompose.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleProducts)
        }
    }
}
