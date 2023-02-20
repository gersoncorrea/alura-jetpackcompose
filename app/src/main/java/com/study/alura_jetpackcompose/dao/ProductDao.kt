package com.study.alura_jetpackcompose.dao

import androidx.compose.runtime.mutableStateListOf
import com.study.alura_jetpackcompose.model.Product

class ProductDao {
    companion object {
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product) = products.add(product)
}
