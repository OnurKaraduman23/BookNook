package com.onuryasarkaraduman.presentation

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.onuryasarkaraduman.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.presentation.HomeContract.UiState

class HomeScreenPreviewProvider: PreviewParameterProvider<UiState> {
    override val values: Sequence<UiState>
        get() = sequenceOf(
            UiState(
                isLoading = true,
                errorMessage = null,
                recommendedList = emptyList()
            ),
            UiState(
                isLoading = false,
                errorMessage = "Not Found",
                recommendedList = emptyList()
            ),
            UiState(
                isLoading = false,
                errorMessage = null,
                recommendedList = listOf(
                    CategoriesRecommendedModel(
                       id = "1",
                        bookName = "Dante's Inferno",
                        bookUrl = "https://www.apple.com/v/watch/bo/images/overview/select/product_se__frx4hb13romm_xlarge.png",
                        category = "fiction / science"
                    ),
                    CategoriesRecommendedModel(
                        id = "2",
                        bookName = "Dante's Inferno",
                        bookUrl = "https://www.apple.com/v/watch/bo/images/overview/select/product_se__frx4hb13romm_xlarge.png",
                        category = "fiction / science"
                    ),
                    CategoriesRecommendedModel(
                        id = "3",
                        bookName = "Dante's Inferno",
                        bookUrl = "https://www.apple.com/v/watch/bo/images/overview/select/product_se__frx4hb13romm_xlarge.png",
                        category = "fiction / science"
                    ),
                    CategoriesRecommendedModel(
                        id = "4",
                        bookName = "Dante's Inferno",
                        bookUrl = "https://www.apple.com/v/watch/bo/images/overview/select/product_se__frx4hb13romm_xlarge.png",
                        category = "fiction / science"
                    ),


                )
            )
        )
}