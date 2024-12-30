package com.onuryasarkaraduman.core.domain.model

data class UserCategoryPreferences(
    val selectedCategories: Set<String> = emptySet()
)
