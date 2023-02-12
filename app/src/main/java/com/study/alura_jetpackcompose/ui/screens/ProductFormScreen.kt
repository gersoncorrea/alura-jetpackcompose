package com.study.alura_jetpackcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProductFormScreen() {
    Column {
        Text(text = "Criando o produto", Modifier.fillMaxWidth().padding(start = 8.dp))

        var name by remember {
            mutableStateOf("")
        }
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            Modifier.fillMaxWidth().padding(top = 16.dp, start = 8.dp, end = 8.dp),
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
            Modifier.fillMaxWidth().padding(top = 16.dp, start = 8.dp, end = 8.dp),
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
            Modifier.fillMaxWidth().height(100.dp).padding(top = 16.dp, start = 8.dp, end = 8.dp),
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
            label = { Text(text = "Descrição") }
        )

        Button(
            onClick = { /*TODO*/ },
            Modifier.fillMaxWidth().padding(top = 16.dp, start = 8.dp, end = 8.dp).height(40.dp)
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
