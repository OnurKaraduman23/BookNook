package com.onuryasarkaraduman.mapper

import com.onuryasarkaraduman.dto.HomeCategoriesResponse
import com.onuryasarkaraduman.model.CategoriesRecommendedModel

fun HomeCategoriesResponse.toDomain(): List<CategoriesRecommendedModel> {
    return this.items.map { item ->
        CategoriesRecommendedModel(
            id = item?.id.orEmpty(),
            bookName = item?.volumeInfo?.title.orEmpty(),
            bookUrl = item?.volumeInfo?.imageLinks?.thumbnail.orEmpty(),
            category = item?.volumeInfo?.categories?.firstOrNull().orEmpty(),
        )
    }
}