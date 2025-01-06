package com.onuryasarkaraduman.presentation

import com.onuryasarkaraduman.model.CategoriesRecommendedModel

object HomeContract {

    data class UiState(
        val isLoading: Boolean = true,
        val recommendedList: List<CategoriesRecommendedModel> = emptyList(),
        val errorMessage: String? = null,
        val setCategories: Set<String> = emptySet(),
        val selectedCategory: String = "",
    )

    sealed class UiAction() {
        data object LoadCategoriesAndFetchBooks : UiAction()
        data class FetchBooksByCategoryChipButtons(val category: String) : UiAction()
    }


    sealed class UiEffect {
        data class GoToDetailScreen(val route: String) : UiEffect()
        data class ShowToastMessage(val message: String) : UiEffect()
    }
}