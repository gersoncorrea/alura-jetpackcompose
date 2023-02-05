package com.study.alura_jetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.alura_jetpackcompose.model.Product
import com.study.alura_jetpackcompose.sampledata.sampleProducts
import com.study.alura_jetpackcompose.sampledata.sampleSections
import com.study.alura_jetpackcompose.ui.components.CardProductItem
import com.study.alura_jetpackcompose.ui.components.ProductSection
import com.study.alura_jetpackcompose.ui.components.SearchTextField

@Composable
fun HomeScreen(sections: Map<String, List<Product>>, searchText: String = "") {
    Column {
        var text = remember { mutableStateOf(searchText) }

        SearchTextField(searchText = text.value, onSearchChange = {
            text.value = it
        }, Modifier.padding(16.dp).fillMaxWidth())

        val searchedProducts = remember(text.value) {
            if (text.value.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(
                        text.value,
                        ignoreCase = true
                    ) || product.description?.contains(
                        text.value,
                        ignoreCase = true
                    ) ?: false
                }
            } else {
                emptyList()
            }
        }

        Spacer(modifier = Modifier)

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.value.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val product = section.value
                    item {
                        ProductSection(title = title, products = product)
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(product = p, Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchTextPreview() {
    HomeScreen(sampleSections, searchText = "Ham")
}
