package com.study.alura_jetpackcompose.sampledata

import com.study.alura_jetpackcompose.R
import com.study.alura_jetpackcompose.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = "Burger",
        price = BigDecimal("14.99"),
        image = R.drawable.burger
    ),
    Product(
        name = "Fries",
        price = BigDecimal("14.99"),
        image = R.drawable.fries
    ),

    Product(
        name = "Pizza",
        price = BigDecimal("14.99"),
        image = R.drawable.pizza
    )
)
