package com.data.repo

import com.data.remote.ApiService
import com.domain.entity.CategoryResponse
import com.domain.repo.MealsRepo

class MealsRepoImp(private val apiService: ApiService) : MealsRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}