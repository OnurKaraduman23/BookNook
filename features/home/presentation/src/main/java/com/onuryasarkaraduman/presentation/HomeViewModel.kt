package com.onuryasarkaraduman.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.core.common.Resource
import com.onuryasarkaraduman.core.domain.preferences.Preferences
import com.onuryasarkaraduman.presentation.HomeContract.UiAction
import com.onuryasarkaraduman.presentation.HomeContract.UiEffect
import com.onuryasarkaraduman.presentation.HomeContract.UiState
import com.onuryasarkaraduman.use_case.GetBooksByCategoriesUseCase
import com.onuryasarkaraduman.use_case.GetRandomCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val getBooksByCategoriesUseCase: GetBooksByCategoriesUseCase,
    private val getRandomCategoryUseCase: GetRandomCategoryUseCase,
) : ViewModel() {

    private val _categoryUiState = MutableStateFlow(UiState())
    val categoryRecommendedUiState = _categoryUiState

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.LoadCategoriesAndFetchBooks -> {
                loadCategoriesAndFetchBooks()
            }

            is UiAction.FetchBooksByCategoryChipButtons -> {
                fetchBooksByCategory(uiAction.category)
            }
        }

    }

    private fun fetchBooksByCategory(category: String) {
        viewModelScope.launch {
            getBooksByCategoriesUseCase(category).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        updateUiSate { copy(isLoading = true, selectedCategory = category) }
                    }

                    is Resource.Success -> {
                        updateUiSate {
                            copy(
                                isLoading = false,
                                recommendedList = result.data.orEmpty(),
                                selectedCategory = category
                            )
                        }
                    }

                    is Resource.Error -> {
                        updateUiSate {
                            copy(
                                isLoading = false,
                                errorMessage = result.message ?: "An unknown error"
                            )
                        }
                    }
                }
            }
        }
    }

    private fun loadCategoriesAndFetchBooks() {
        val categories = preferences.getCategories()
        val randomCategory = getRandomCategoryUseCase.execute(categories)


        viewModelScope.launch {
            getBooksByCategoriesUseCase(randomCategory).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        updateUiSate { copy(isLoading = true, setCategories = categories) }
                    }

                    is Resource.Success -> {
                        updateUiSate {
                            copy(
                                isLoading = false,
                                recommendedList = result.data.orEmpty()
                            )

                        }
                    }

                    is Resource.Error -> {
                        updateUiSate {
                            copy(
                                isLoading = false,
                                errorMessage = result.message ?: "An unknown Error"
                            )
                        }
                    }

                }

            }
        }

    }


    private fun updateUiSate(block: UiState.() -> UiState) {
        _categoryUiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}