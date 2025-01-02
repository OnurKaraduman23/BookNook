package com.onuryasarkaraduman.design_system

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoriesChips(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.yellow)
        ),
        onClick = {
            onClick()
        }
    ) {
        Text(
            text = title,
        )
    }

}