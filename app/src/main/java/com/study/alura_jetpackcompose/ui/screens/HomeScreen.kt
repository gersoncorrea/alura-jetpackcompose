package com.study.alura_jetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.alura_jetpackcompose.R
import com.study.alura_jetpackcompose.model.Product
import com.study.alura_jetpackcompose.sampledata.sampleProducts
import com.study.alura_jetpackcompose.ui.components.ProductSection
import java.math.BigDecimal

@Composable
fun HomeScreen() {
    Column(
        Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        ProductSection("Promoções", sampleProducts)
        ProductSection(
            "Doces",
            listOf(
                Product(
                    name = "Chocolate",
                    price = BigDecimal("5.99"),
                    image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg"
                )
            )
        )
        ProductSection("Bebidas", sampleProducts)
        Spacer(modifier = Modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
