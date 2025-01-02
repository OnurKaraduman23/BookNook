package com.onuryasarkaraduman.design_system


import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.onuryasarkaraduman.core.R


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GlideImageAsync(imageUrl: String) {
    GlideImage(
        model = imageUrl,
        contentDescription = "Product thumbnail image",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(250.dp)
    ) {
        it.load(imageUrl)
            .placeholder(R.drawable.art)
            .error(R.drawable.art)
    }
}
