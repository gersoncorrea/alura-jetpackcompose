package com.study.alura_jetpackcompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.study.alura_jetpackcompose.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    Text(text = "Formulário de produto")
                }
            }
        }
    }
}