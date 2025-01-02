package com.onuryasarkaraduman.repository

import com.onuryasarkaraduman.mapper.toDomain
import com.onuryasarkaraduman.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.remote.HomeApiService
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeApiService
): HomeRepository{

    override suspend fun getBooksByCategory(subject: String): List<CategoriesRecommendedModel> {
       return homeDataSource.getBooksByCategory(subject).toDomain()
    }


}