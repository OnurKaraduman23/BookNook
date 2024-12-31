package com.onuryasarkaraduman.presentation.categories_selector

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.core.domain.model.UserCategory
import com.onuryasarkaraduman.core.domain.preferences.Preferences
import com.onuryasarkaraduman.presentation.categories_selector.CategoriesContract.CategoriesUiAction
import com.onuryasarkaraduman.presentation.categories_selector.CategoriesContract.CategoriesUiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val preferences: Preferences,
) : ViewModel() {


    private val _uiEffect by lazy { Channel<CategoriesUiEffect>() }
    val uiEffect: Flow<CategoriesUiEffect> by lazy { _uiEffect.receiveAsFlow() }


    fun onAction(uiAction: CategoriesUiAction) {
        when (uiAction) {
            is CategoriesUiAction.SaveCategories -> saveSelectedCategories(uiAction.selectedStates)
        }

    }

    fun saveSelectedCategories(selectedStates: List<Boolean>) {
        viewModelScope.launch {
            val selectedCategories = UserCategory.entries
                .filterIndexed { index, _ -> selectedStates[index] }
                .map { it.value }
                .toSet()
            preferences.saveCategories(selectedCategories)
            emitUiEffect(CategoriesUiEffect.GoToNextScreen)
        }

    }


    private suspend fun emitUiEffect(uiEffect: CategoriesUiEffect) {
        _uiEffect.send(uiEffect)
    }
}
