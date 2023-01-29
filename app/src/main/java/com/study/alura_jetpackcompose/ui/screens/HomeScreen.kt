package com.study.alura_jetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.alura_jetpackcompose.model.Product
import com.study.alura_jetpackcompose.sampledata.sampleProducts
import com.study.alura_jetpackcompose.ui.components.ProductSection

@Composable
fun HomeScreen(sampleProducts: List<Product>) {
    Column {
        val text = remember { mutableStateOf("") }
        OutlinedTextField(
            value = text.value,
            onValueChange = { newValue ->
                text.value = newValue
            },
            Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp).fillMaxWidth(),
            shape = RoundedCornerShape(25),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "ícone de lupa") },
            label = {
                Text(text = "Produto")
            },
            placeholder = {
                Text(text = "O que você procura?")
            }
        )
        Spacer(modifier = Modifier)

        LazyColumn(
            Modifier.fillMaxSize().padding(top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                ProductSection("Bebidas", sampleProducts)
                Spacer(modifier = Modifier)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleProducts)
}
