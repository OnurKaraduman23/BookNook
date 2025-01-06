package com.onuryasarkaraduman.design_system

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesSegmentedButtonRow(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
) {
    val selectedIndex = categories.indexOf(selectedCategory)


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        SingleChoiceSegmentedButtonRow {
            categories.forEachIndexed { index, category ->
                SegmentedButton(
                    onClick = { onCategorySelected(category) },
                    selected = selectedIndex == index,
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = categories.size
                    ),
                    colors = SegmentedButtonDefaults.colors(
                        inactiveBorderColor = colorResource(id = R.color.yellow),
                        activeBorderColor = colorResource(id = R.color.yellow),
                        activeContainerColor = colorResource(id = R.color.yellow),
                    )
                ) {
                    Text(text = category)
                }
            }
        }
    }
}
