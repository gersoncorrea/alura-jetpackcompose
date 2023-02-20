package com.study.alura_jetpackcompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.study.alura_jetpackcompose.dao.ProductDao
import com.study.alura_jetpackcompose.ui.screens.ProductFormScreen
import com.study.alura_jetpackcompose.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen(onSaveClick = { product ->
                        dao.save(product)
                        this.finish()
                    })
                }
            }
        }
    }
}
