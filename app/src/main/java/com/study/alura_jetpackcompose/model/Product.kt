package com.study.alura_jetpackcompose.model

import androidx.annotation.DrawableRes
import com.study.alura_jetpackcompose.R
import java.math.BigDecimal

class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int = R.drawable.ic_launcher_background
)
