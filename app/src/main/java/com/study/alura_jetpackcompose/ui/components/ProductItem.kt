package com.study.alura_jetpackcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.study.alura_jetpackcompose.R
import com.study.alura_jetpackcompose.extensions.toBrazilianCurrency
import com.study.alura_jetpackcompose.model.Product
import com.study.alura_jetpackcompose.ui.theme.Purple500
import com.study.alura_jetpackcompose.ui.theme.Teal200
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier, elevation: Dp = 4.dp) {
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = elevation
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500,
                                Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        product = Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal("14.99"),
            image = null,
            description = LoremIpsum(100).values.first()
        )
    )
}
