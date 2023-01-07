package com.study.alura_jetpackcompose.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.toBrazilianCurrency(): String {
    return NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
        .format(this)
}
