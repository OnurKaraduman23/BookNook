package com.onuryasarkaraduman.use_case

import com.onuryasarkaraduman.core.common.Resource
import com.onuryasarkaraduman.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetBooksByCategoriesUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
) {
    operator fun invoke(subject: String): Flow<Resource<List<CategoriesRecommendedModel>>> = flow {

        try {
            emit(Resource.Loading<List<CategoriesRecommendedModel>>())
            val response = homeRepository.getBooksByCategory(subject)
            emit(Resource.Success<List<CategoriesRecommendedModel>>(response))
        } catch (e: IOException) {
            emit(Resource.Error<List<CategoriesRecommendedModel>>("Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            emit(
                Resource.Error<List<CategoriesRecommendedModel>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        }
    }


}