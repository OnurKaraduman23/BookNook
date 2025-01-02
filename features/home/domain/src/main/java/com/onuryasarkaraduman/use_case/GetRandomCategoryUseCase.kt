package com.onuryasarkaraduman.use_case

import javax.inject.Inject

class GetRandomCategoryUseCase @Inject constructor() {
    fun execute(categories: Set<String>): String {
        require(categories.isNotEmpty()) { "Categories list cannot be empty" }
        return categories.random()
    }
}