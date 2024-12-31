package com.onuryasarkaraduman.presentation.categories_selector

object CategoriesContract {

    sealed class CategoriesUiAction() {
        data class SaveCategories(val selectedStates: List<Boolean>) : CategoriesUiAction()
    }

    sealed class CategoriesUiEffect {
        data object GoToNextScreen : CategoriesUiEffect()
    }
}
