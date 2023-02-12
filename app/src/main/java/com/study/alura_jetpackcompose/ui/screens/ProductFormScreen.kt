package com.study.alura_jetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.study.alura_jetpackcompose.R
import com.study.alura_jetpackcompose.model.Product
import java.math.BigDecimal

@Composable
fun ProductFormScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Criando o produto",
            Modifier
                .fillMaxWidth(),
            fontSize = 26.sp
        )

        var url by remember {
            mutableStateOf("")
        }

        if (url.isNotBlank()) {
            AsyncImage(
                model = url,
                contentDescription = null,
                Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
        }
        TextField(
            value = url,
            onValueChange = {
                url = it
            },
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
            label = { Text(text = "Url da imagem") }
        )

        var name by remember {
            mutableStateOf("")
        }
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
            label = { Text(text = "Nome") }
        )

        var price by remember {
            mutableStateOf("")
        }
        TextField(
            value = price,
            onValueChange = {
                price = it
            },
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
            label = { Text(text = "Valor") }
        )

        var description by remember {
            mutableStateOf("")
        }
        TextField(
            value = description,
            onValueChange = {
                description = it
            },
            Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
            label = { Text(text = "Descrição") }
        )

        val convertedPrice = try {
            BigDecimal(price)
        } catch (e: java.lang.NumberFormatException) {
            BigDecimal.ZERO
        }
        Button(
            onClick = {
                Product(
                    name = name,
                    image = "",
                    price = convertedPrice,
                    description = description
                )
            },
            Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Text(text = "Salvar")
        }
    }
}

@Preview()
@Composable
fun ProductFormScreenPreview() {
    Surface {
        ProductFormScreen()
    }
}
