package com.meals.di

import com.data.remote.ApiService
import com.data.repo.MealsRepoImp
import com.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): MealsRepo {
        return MealsRepoImp(apiService)
    }
}