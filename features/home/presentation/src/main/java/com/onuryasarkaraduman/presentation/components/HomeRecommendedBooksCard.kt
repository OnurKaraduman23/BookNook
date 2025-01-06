package com.onuryasarkaraduman.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.R
import com.onuryasarkaraduman.design_system.GlideImageAsync
import com.onuryasarkaraduman.model.CategoriesRecommendedModel

@Composable
fun HomeRecommendedBooksCard(
    modifier: Modifier = Modifier,
    book: CategoriesRecommendedModel,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.padding(8.dp)
            .size(width = 150.dp, height = 250.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.yellow)
        ),
        onClick = { onClick() },

        ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            GlideImageAsync(
                imageUrl = book.bookUrl
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.align(Alignment.Start)
                    .padding(4.dp),
                text = book.bookName,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeRecommendedBooksCardPreview() {
    HomeRecommendedBooksCard(
        book = CategoriesRecommendedModel(
            id = "asf",
            bookName = "Dante's Inferno,Dante's Inferno,Dante's Inferno,Dante's Inferno,Dante's Inferno",
            bookUrl = "Image"
        ),
        onClick = {}
    )
}