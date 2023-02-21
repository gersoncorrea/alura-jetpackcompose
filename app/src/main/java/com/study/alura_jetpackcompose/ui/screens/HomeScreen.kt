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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.alura_jetpackcompose.model.Product
import com.study.alura_jetpackcompose.sampledata.sampleProducts
import com.study.alura_jetpackcompose.sampledata.sampleSections
import com.study.alura_jetpackcompose.ui.components.CardProductItem
import com.study.alura_jetpackcompose.ui.components.ProductSection
import com.study.alura_jetpackcompose.ui.components.SearchTextField

class HomeScreenUiState(searchText: String = "") {
    var text by mutableStateOf(searchText)
        private set

    val searchedProducts
        get() =
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(
                        text,
                        ignoreCase = true
                    ) ||
                        product.description?.contains(
                            text,
                            ignoreCase = true
                        ) ?: false
                }
            } else emptyList()

    fun isShowSections(): Boolean {
        return text.isBlank()
    }

    val onSearchChange: (String) -> Unit = { searchText ->
        text = searchText
    }
}

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val text = state.text
        val searchedProducts = remember {
            state.searchedProducts
        }
        SearchTextField(
            searchText = text,
            onSearchChange = { state.onSearchChange },
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier)

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
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
    HomeScreen(sampleSections, state = HomeScreenUiState(searchText = "a"))
}
