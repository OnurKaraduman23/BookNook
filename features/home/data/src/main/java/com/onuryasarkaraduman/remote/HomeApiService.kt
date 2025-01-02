package com.onuryasarkaraduman.remote

import com.onuryasarkaraduman.core.common.Constants.API_KEY
import com.onuryasarkaraduman.core.common.Resource
import com.onuryasarkaraduman.dto.HomeCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiService {
    @GET("volumes")
    suspend fun getBooksByCategory(
        @Query("q") subject: String,
        @Query("key") apiKey: String = API_KEY
    ): HomeCategoriesResponse
}