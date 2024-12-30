package com.onuryasarkaraduman.presentation.welcome.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.R

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    title: String,
    widthFraction: Float = 0.5f,
    @DrawableRes image: Int,
    isSelected: Boolean,
    onToggleSelect: () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(widthFraction)
            .aspectRatio(1f) // Kendi oranını ayarla
            .padding(8.dp)
            .clickable { onToggleSelect() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) colorResource(id = R.color.yellow_selection) else Color.White,
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Görsel
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f),
                contentScale = ContentScale.Crop
            )
            // Metin
            Text(
                text = title,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(0.3f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

