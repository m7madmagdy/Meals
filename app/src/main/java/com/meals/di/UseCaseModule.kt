package com.meals.di

import com.data.remote.ApiService
import com.data.repo.MealsRepoImp
import com.domain.repo.MealsRepo
import com.domain.usercase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(mealsRepo: MealsRepo): GetMeals {
        return GetMeals(mealsRepo)
    }

}