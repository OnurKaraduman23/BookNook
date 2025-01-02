package com.onuryasarkaraduman.repository

import com.onuryasarkaraduman.model.CategoriesRecommendedModel

interface HomeRepository {
    suspend fun getBooksByCategory(subject: String): List<CategoriesRecommendedModel>
}